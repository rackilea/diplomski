//mark input
public void markin() {
    System.out.println("=====================================");
    System.out.println("Please enter the mark of the students");
    System.out.println("=====================================");
    for (int g = 0; g != marks.length; g++) {
        System.out.println(names[g]);
        do {
           System.out.println("Kindly enter a number that is less than 100");
           marks[g] = Keyboard.readInt();
        } while(marks[g]<0||marks[g]>100);
    }
}