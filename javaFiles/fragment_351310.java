PrintWriter pw = new PrintWriter("file3.txt");
    readAndWrite(pw, "file1.txt");
    readAndWrite(pw, "file2.txt");

    pw.flush();
    pw.close();