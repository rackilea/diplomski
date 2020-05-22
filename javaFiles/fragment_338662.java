ReactiveSeq.fromStream(Stream.of(1,2))
                .filter(this::include)
                .elapsed()
                .map(this::logAndUnwrap)
                .map(FluentFunctions.of(this::convertToResult)
                                   .around(a->{

                                    SimpleTimer timer = new SimpleTimer();
                                    String r = a.proceed();
                                    mapTimeTakenNanos[mapIndex++]=timer.getElapsedNanos();
                                    return r;
                }));