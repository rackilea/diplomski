public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    // boxes array
    Boolean[] boxes = new Boolean[26];
    Arrays.fill(boxes, false);

    // values array
    int[] values = new int[26];
    for(int i=0; i<values.length; i++) {
      values[i] = rand.nextInt(10);
    }

    int box;
    while(true) {
      for(int i=0; i<boxes.length; i++) {
        // if opened print the value, if closed print the box
        String boxString = boxes[i] ? " "+values[i]+"  " : "["+(i+1)+"] ";
        System.out.print(boxString);
      }
      System.out.println("\nChoose a box");
      box = sc.nextInt();
      boxes[box-1] = true;
    }
  }