RandomAccessFile FileA = new RandomAccessFile("File.dat", "rw");
        System.out.println("Writing 100");
        for (int i = 0; i < 100; i++) {
            FileA.writeInt(i);
        }
        FileA = new RandomAccessFile("File.dat", "r");
        RandomAccessFile FileB = new RandomAccessFile("File.dat", "r");


        FileA.seek(0);
        DataInputStream InputStreamA = new DataInputStream(new BufferedInputStream(
                new FileInputStream(FileA.getFD())));

        FileB.seek(0);
        DataInputStream InputStreamB = new DataInputStream(new BufferedInputStream(
                new FileInputStream(FileB.getFD())));


        System.out.println("Read A");
        for (int i = 0; i < 10; i++) {
            System.out.println(InputStreamA.readInt());
        }

        System.out.println("Read B");
        for (int i = 0; i < 10; i++) {
            System.out.println(InputStreamB.readInt());
        }

        System.out.println("Run A");
        for (int i = 0; i < 10; i++) {
            System.out.println(InputStreamA.readInt());
        }

        System.out.println("Run B");
        for (int i = 0; i < 10; i++) {
            System.out.println(InputStreamB.readInt());
        }