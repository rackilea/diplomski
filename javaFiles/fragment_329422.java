public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print(" please tell input with format of TITLE-CHARACTER-YEAR ");
    String input = scanner.nextLine(); //reads the input from console 
    String arr[] = new String[3]; // size ur wish
    arr=input.split("-"); //splits the input with the - delimiter into array of strings
    String name=arr[1]; //contains character
    int year=Integer.parseInt(arr[2]); //contains year
    if(year<2000)
        System.out.println( name + " 90's");
    else if(year>=2000 && year<2006)
        System.out.println(name + " early 2000's");
    else if(year>=2006)
        System.out.println(name + " latest");
}