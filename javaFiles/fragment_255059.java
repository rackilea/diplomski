Scanner sc = new Scanner(System.in);
    ArrayList<Integer[]> addIt = new ArrayList<>();
    boolean choice = false;

    while(choice == false){
        String line = sc.nextLine();
        if(line.equalsIgnoreCase("n")){
            break;
        }
        else{
            String[] splitArr = line.split("\\s+");
            Integer[] convertedArr = new Integer[splitArr.length];
            for(int i = 0; i < convertedArr.length; i++){
                convertedArr[i] = Integer.parseInt(splitArr[i]);
            }
            addIt.add(convertedArr);
        } 
    }