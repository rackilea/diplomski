try (FileInputStream fin=new FileInputStream(args[0]);
     FileOutputStream fout=new FileOutputStream(args[1])) {
    byte[] bytes = new byte[8192];
    for (int len; (len = fin.read(bytes)) > 0; )
        fout.write(bytes, 0, len);
} // try-with-resource will close the files.