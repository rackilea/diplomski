// Note the lack of "cmd \c" - you shouldn't need to run it in a cmd window!
ProcessBuilder pb = new ProcessBuilder("pocketsphinx_continuous.exe",
                                       "dict", "1121.dic",
                                       "-lm", "1121.lm",
                                       "-hmm", "hub4/hmm");

Process p = pb.start();

// TODO for you:
// 1. Create Threads to handle the input
// 2. Store the Process instance so that you can call p.destroy() later.
// 3. If interested, have a Thread doing p.waitFor() to get the exit code.