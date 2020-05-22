public static Scanner console = new Scanner(System.in);
public static int studSize;
public static String [] gradeArr;
public static int [] gradeInt;

public static void initialize(){

    // not needed - 
    System.out.print("Please enter student size: ");
    String studString = console.nextLine();

    // not needed 
    studSize = Integer.parseInt(studString);
    enterData();
}
public static void enterData(){
    System.out.println("Enter student grades separated with dash(-)");
    System.out.print("Enter student grade/s: ");
    String gradeString = console.nextLine();
    gradeArr = gradeString.split("-");
    convert();
}
public static void convert(){
    // set here as the size is know
    gradeInt = new int[gradeArr.length];

    for(int i=0; i<gradeArr.length; i++){
        // should be carefull of NumberFormatException
        gradeInt[i] = Integer.parseInt(gradeArr[i]);
    }
    print();
}
public static void print(){
    System.out.print(Arrays.toString(gradeInt));
}
public static void main(String [] args){
    initialize();
    //Main and Class Closing Braces
}