public static void main(String[] args) {    
String one, two, three,four, five,six,seven,eight;
      Scanner kbrd = new Scanner(System.in);
      System.out.println("please enter a phrase, and then pick three words that you want to switch");
      one= kbrd.nextLine();

      two= kbrd.next()+" "; // Added space
      three = kbrd.next()+" "; // Added space
      four = kbrd.next()+" "; // Added space
      seven = two+three+four;

      System.out.println(one.indexOf(two));
      System.out.println(one.lastIndexOf(four));

      five = four.toUpperCase()+three+two.toUpperCase();
      System.out.println(five);

      eight = one.replace(seven.trim(),five.trim()); // timing the last space
      System.out.println(eight);
}