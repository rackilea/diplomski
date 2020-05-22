Scanner sc = new Scanner(new File ("C:/correct/path/to/file/master_file.txt")); 

    List<String> listOfStrings = new ArrayList<String>(); 

        while(sc.hasNextLine()) {

           listOfStrings.add(sc.nextLine());

        }

    System.out.println(listOfStrings);