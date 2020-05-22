PipedInputStream pout = new PipedInputStream((PipedOutputStream) out);
/**
* ...
*/
BufferedReader consoleOutput = new BufferedReader(new InputStreamReader(pout));
consoleOutput.readLine();