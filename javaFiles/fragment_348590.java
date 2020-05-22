public static void findAndPrint() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("C:\\yourfilepath\\actualfile.txt"));
        //you can get user input etc here if necessary
        String input = "pass";
        while (in.hasNext()) {
            String line = in.nextLine();
            if (line.contains(input)) {
                System.out.println(line);
            }
        }
    }