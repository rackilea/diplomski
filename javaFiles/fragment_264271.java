Process process = Runtime.getRuntime().exec("...");
    ...
    OutputStream child_stdin = process.getOutputStream();
    BufferedWriter child_writer = new BufferedWriter(new OutputStreamWriter( child_stdin ));
    child_writer.write( userPassword );
    child_writer.newLine();  // suggested by OP
    child_writer.flush();