public static void main(String [] args){
    ArrayList<String> randomTextlist = new ArrayList<String>();
    ArrayList<Double> doublelist = new ArrayList<Double>();
    ArrayList<Integer> intlist = new ArrayList<Integer>();
    boolean input = true;

    Scanner scan = new Scanner(System.in);

    while (input){
        System.out.print("Input string, int, or double.");
        //exit loop case: input false, or how would you exit the loop?
        if (scan.hasNextBoolean()){
            break;
        }

        if (scan.hasNextDouble()){
            doublelist.add(scan.nextDouble());
        }
        else if (scan.hasNextInt()){
            intlist.add(scan.nextInt());
        }
        else{
            randomTextlist.add(scan.next());
        }
    }
    Collections.sort(doublelist);
    System.out.println(doublelist);
    Collections.sort(intlist);
    System.out.println(intlist);
    Collections.sort(randomTextlist);
    System.out.println(randomTextlist);
    }