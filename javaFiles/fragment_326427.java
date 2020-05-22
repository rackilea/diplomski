Scanner keyboard = new Scanner(System.in);
 String input = keyboard.nextLine();
 int intChar = (int)input.charAt(0);
 List<Integer> matClassificationInts = new ArrayList<Integer>();
 if (Arrays.binarySearch(intValidChars, intChar) >=0) {
    matClassificationInts.add(new Integer(intChar));
    ......
 }
 String dataImages = "";
 for (Integer i : matClassificationInts) {
     dataImages += i + " ";
 }