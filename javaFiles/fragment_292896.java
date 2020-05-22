try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
    int counter = 0;

    int size;        
    while ((size = in.readInt()) != -1) {
        byte[] buffer = new byte[size];
        in.readFully(buffer);

        try (FileOutputStream out = new FileOutputStream(new File("pics/out/" + (counter++) +".jpeg"))) {
            out.write(buffer);
            out.flush();
        }
    }
}