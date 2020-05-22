FileInputStream fIn = ...;
BufferedReader bRead = new BufferedReader(new InputStreamReader(fIn));

// ... read through bRead ...

// "reset" to beginning of file (discard old buffered reader)
fIn.getChannel().position(0);
bRead = new BufferedReader(new InputStreamReader(fIn));