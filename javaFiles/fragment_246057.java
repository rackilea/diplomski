boolean readSuspended = ctx.getAttachment() != null;
            if (readSuspended) {
                // Drop the request silently if MemoryAwareThreadPool has
                // set the flag.
                e.getFuture().setSuccess();
                return;
            }