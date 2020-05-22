public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    Stack<String> s = new Stack<String>();
    int i = 0;
    int x = 0;
    String strLine;
    while ((strLine = r.readLine()) != null){ // Read until end of File
        s.push(strLine); // add to the Stack
        i++;
        if(i==50) // Print if is equal to 50
        {
            while (!s.isEmpty()) {
                System.out.println(s.pop());
            }
            i=0;
        }
    }

    while (!s.isEmpty()) {
        System.out.println(s.pop()); // Print the last numbers
    }
}