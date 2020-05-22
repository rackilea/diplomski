Runtime rt = Runtime.getRuntime();

Process proc;
try {
  proc = rt.exec(command);
} catch (IOException e) {
  throw new CustomException("Failed to execute.", e);
}

StreamRedirector outStreamRedirector = new StreamRedirector(proc.getInputStream(), System.out);
StreamRedirector errStreamRedirector = new StreamRedirector(proc.getErrorStream(), System.err);

outStreamRedirector.start();
errStreamRedirector.start();

int exitVal;
try {
  outStreamRedirector.join();
  errStreamRedirector.join();
  exitVal = proc.waitFor();
} catch (InterruptedException e) {
  throw new CustomException("Failed to execute.", e);
}