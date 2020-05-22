char[] input = new char[150];
for (int i = 0 ; i != 10 ; i++) {
    System.out.println("Enter some characters. We are going to do this for a while.");
    char[] buf = kb.nextLine().toCharArray();
    // Copy the data into input
    System.arraycopy(buf, 0, input, 140-(i*10), Math.min(buf.length, 10));
}