sectionSem[nextPosition].P(); // wait for the section ahead to be
                                    // free
    trackSections[nextPosition] = "[A" + trainName + "]"; // move
                                                            // forward
    trackSections[currentPosition] = "[..]"; // clear section vacated
    // record the train activity
    theTrainActivity.addMovedTo(nextPosition);
    sectionSem[currentPosition].V(); // signal the section you vacated
                                        // now free