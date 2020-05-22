private void recursivelyPopulateDataFiles(long fromId) {

            List<Localfile> unproccessed = DB.fetchAllFilesFromId(fromId, limit);

            if ( unproccessed.size() > 0 ) {

                    Concurrency.async(
                            THE_EXECUTOR,

                            0,

                            unproccessed.size(),

                            ITERATIONS_COUNTER_IN_PROGRESS_CAN_BE_USED_BY_OTHERS_TO_LISTEN_GLOBALLY_FOR_WHEN_IT_HITS_ZERO_AGAIN::incrementAndGet,

                            (Integer index) -> () -> {
                                    populateDataFile( unproccessed.get(index) );
                            },

                            0.5,

                            () -> {
                                    recursivelyPopulateDataFiles(unproccessed.get(unproccessed.size() - 1).getId());

                            },

                            ITERATIONS_COUNTER_IN_PROGRESS_CAN_BE_USED_BY_OTHERS_TO_LISTEN_GLOBALLY_FOR_WHEN_IT_HITS_ZERO_AGAIN::decrementAndGet
                    );

            }

    }