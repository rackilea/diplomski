if (!wakeupCalled.getAndSet(false) && (selected == 0) && (delta < 100)) {
                    // Last chance : the select() may have been
                    // interrupted because we have had an closed channel.
                    if (isBrokenConnection()) {
                        LOG.warn("Broken connection");
                    } else {
                        LOG.warn("Create a new selector. Selected is 0, delta = " + (t1 - t0));
                        // Ok, we are hit by the nasty epoll
                        // spinning.
                        // Basically, there is a race condition
                        // which causes a closing file descriptor not to be
                        // considered as available as a selected channel,
                        // but
                        // it stopped the select. The next time we will
                        // call select(), it will exit immediately for the
                        // same
                        // reason, and do so forever, consuming 100%
                        // CPU.
                        // We have to destroy the selector, and
                        // register all the socket on a new one.
                        registerNewSelector();
                    }
                }