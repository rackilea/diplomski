static String fileName = "files.txt";
static byte[] searchString = { 'f', 'i', 'r', 's', 't' };
static int count = 0;
static long position = 1;
public static void main(String[] args) throws IOException {

    try (FileInputStream file = new FileInputStream(fileName)) {
        byte read[] = new byte[1];
        outerLoop: while (-1 < file.read(read, 0, 1)) {
            position++;
            if (read[0] == searchString[0]) {
                int matches = 1;
                for (int i = 1; i < searchString.length; i++) {
                    if (-1 > file.read(read, 0, 1)) {
                        break outerLoop;
                    }
                    position++;
                    if (read[0] == searchString[i]) {
                        matches++;
                    } else {
                        break;
                    }
                }
                if (matches == searchString.length) {
                    System.out.println((++count)+". found at position "+ (position-matches));
                }
            }

        }
        file.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}