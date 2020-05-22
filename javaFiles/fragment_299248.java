public static void updateInventory(String filename1, String filename2, String[] name1, int[] quantity1) {
    File updated = new File(filename1);
    Scanner input = null;
    try {
        input = new Scanner(updated);
    } catch (FileNotFoundException e) {
        System.out.println("Error reading file, " + filename1);
    }
    FileWriter log = null;
    PrintWriter output = null;
    try {
        log = new FileWriter(filename2, true);
        output = new PrintWriter(log);
    } catch (Exception e) {
        System.out.println("Error creating log file, " + filename2);
    }
    int i = 0;
    int num = 0;
    String s;
    while (input != null && input.hasNext() && i < name1.length && i < quantity1.length) {
        s = input.next();
        s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        if (s.equals(name1[i]) && input.hasNextInt()) {
            num = input.nextInt();
            if (num >= 0 && num < quantity1[i]) {
                quantity1[i] -= num;
            }
        }
        if (i == name1.length) {
            output.println("ERROR: Item " + s + " not found");
        }
        if (num < 0) {
            output.println("ERROR: Invalid amount requested (" + num + ")");
        }
        i++;
    }
    output.close();
    input.close();
}