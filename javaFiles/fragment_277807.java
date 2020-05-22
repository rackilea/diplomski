InvokeScript.execute(String args) {
// Process args, convert them to command array or whatever is comfortable

Process p = Runtime.getRuntime().exec(cmdArray);

ReaderThread rt = new ReaderThread(p.getInputStream());
rt.start();
}