int pick = in.nextInt();
in.nextLine();            //this is what's needed to detect the newline

if(pick == 1) {
    //first name input
    System.out.println("What is the employees first name: ");
    String eFirst = in.nextLine();
    e1.setFirst(eFirst);
    //in.hasNext();           (you don't need this)
    //last name input  
    System.out.println("What is their last name: ");
    String eLast = in.nextLine();
    e1.setLast(eLast);
    //in.hasNext();           (you don't need this)

    System.out.println(e1.toString() + eFirst);
}