static int count = 0;
static String input = "";

public static void main(String args[]){
    addClient();
}

public static int addClient() {

    try {
        BufferedReader in = new BufferedReader(new FileReader("test.txt"));
        input = in.readLine();
        if (input != null)
            count = Integer.parseInt(input);
        System.out.println("Client count is: " + count);
        count++;
        in.close();

        System.out.println("After increment, count is: " + count);

        PrintWriter out = new PrintWriter(new FileWriter("test.txt"));
        String output = Integer.toString(count);
        System.out.println("Output is " + output);

        out.println(output);
        out.flush();out.close();

    } catch(FileNotFoundException e) {
        System.out.println("FNFE!");
        System.exit(1);
    } catch(IOException e) {
        System.out.println("IOE!");
        System.exit(1);
    }

    return count;
}
}