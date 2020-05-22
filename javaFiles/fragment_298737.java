File f = new File("D:/abc.txt");
RandomAccessFile file;
try {
    file = new RandomAccessFile(f, "r");
    long file_size = file.length();
    long chosen_byte = (long)(Math.random() * file_size);

    file.seek(chosen_byte);

    for (;;)
    {
        byte a_byte = file.readByte();
        char wordChar = (char)a_byte;
        if (chosen_byte >= file_size || wordChar == '\n' || wordChar == '\r' || wordChar == -1) break;
        else chosen_byte += 1;
        System.out.println("\"" + Character.toString(wordChar)  + "\"");
    }

    int chosen = -1;
    if (chosen_byte < file_size) 
    {
        String s = file.readLine();
        chosen = Integer.parseInt(s);
        System.out.println("Chosen id : \"" + s  + "\"");
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}