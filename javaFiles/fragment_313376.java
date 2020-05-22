public static void main(String []args) {
    int num = 0;
    BufferedReader in = null;
    try {
        in = new BufferedReader(new InputStreamReader(System.in));
        while (num != 999){
            System.out.println("Enter a number:");
            num = Integer.parseInt(in.readLine());
            System.out.println("You typed: " + num);
        }
    } catch (Exception e) {
        //handle your exception, probably with a message
        //showing a basic example
        System.out.println("Error while reading the data.");
        e.printStacktrace(System.in);
    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (Exception e) {
                System.out.println("Problem while closing the reader.");
                e.printStacktrace(System.in);
            }
        }
    }
    System.out.println("999 entered, so the loop has ended.");
}