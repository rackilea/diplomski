...
    read.close();
    FileWriter fw = new FileWriter(file,false);
    for (String itemFile1 : itemFile) {
        fw.write(itemFile1);
        fw.write(System.lineSeparator()); //new line
    }
    fw.close();