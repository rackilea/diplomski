@Override
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);

            ArrayBuffer.OfRef<T> sb = null;
            PermitStatus permitStatus;
            while ((permitStatus = permitStatus()) != PermitStatus.NO_MORE) {
                if (permitStatus == PermitStatus.MAYBE_MORE) {
                    // Optimistically traverse elements up to a threshold of CHUNK_SIZE
                    if (sb == null)
                        sb = new ArrayBuffer.OfRef<>(CHUNK_SIZE);
                    else
                        sb.reset();
                    long permitsRequested = 0;
                    do { } while (s.tryAdvance(sb) && ++permitsRequested < CHUNK_SIZE);
                    if (permitsRequested == 0)
                        return;
                    sb.forEach(action, acquirePermits(permitsRequested));
                }
                else {
                    // Must be UNLIMITED; let 'er rip
                    s.forEachRemaining(action);
                    return;
                }
            }
        }