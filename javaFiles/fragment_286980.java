String encoding = "UTF-8";
Writer w =
    new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(),
                                              encoding));
w.write("Hello World!\n");
w.write("And another line.\n");
w.flush();