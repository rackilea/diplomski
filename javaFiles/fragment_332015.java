public static void UI(Scanner console) throws FileNotFoundException {
        String choice = "Start";
        while (!choice.equals("q")) {
            Scanner fileSearch = new Scanner(new File("simple.txt"));
            System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
            choice = console.next();
            choice = choice.toLowerCase();
            if (choice.equals("c")) {
                System.out.println("Create");
                CreateMadLibs(fileSearch);
            } else if (!choice.equals("q")) {
                System.out.println("I don't understand.");
            }
            fileSearch.close();
        }
    }