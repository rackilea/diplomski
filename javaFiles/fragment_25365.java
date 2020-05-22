StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");

// any output?
StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream(), "OUTPUT");

// start gobblers
outputGobbler.start();
errorGobbler.start();