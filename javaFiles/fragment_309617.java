public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    try {
        while (!input.equalsIgnoreCase("stop")) {
            showMenu();
            input = in.readLine();
            if(input.equals("1")) {
                //do something
            }
            else if(input.equals("2")) {
                //do something else
            }
            else if(input.equals("3")) {
                // do something else
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void showMenu() {
    System.out.println("Enter 1, 2, 3, or \"stop\" to exit");
}