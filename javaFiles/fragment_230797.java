for(File file : dir.listFiles()) {
    try ( // Create an input stream
        Scanner input = new Scanner(file);
    ) {
        while (input.hasNext()) {

            String[] words = input.nextLine().split("[ \n\t\r\"\'.,;:!?()]");

            store(map, words);
        }
        //Here use Printwriter
        try(PrintWriter pw = new PrintWriter(file.getName() + "_out.txt") {
            //iterate over entryset and clear the map after with map.clear()
        }
    }