File file = new File("/home/ok.txt");
        RandomAccessFile rafile;
        try {
            rafile = new RandomAccessFile(file, "rw");
            rafile.setLength(1024);

        } catch (Exception e) {
            e.printStackTrace();
        }