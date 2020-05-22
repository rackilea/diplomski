public static void main() throws IOException{

    File file = new File ("count.dat");
    RandomAccessFile RAF = new RandomAccessFile(file, "rw"); // rw stands for read and write

    if (RAF.length() == 0){ //Checks if file is empty

        RAF.writeInt(1);
        System.out.println("File was empty!");

    }else{

        int count = RAF.readInt() + 1;
        RAF.seek(0); //file pointer at position 0
        System.out.println(count);
        RAF.writeInt(count);

    }

    RAF.close();

}