public static void main(String[] args) {
    // TODO code application logic here


    Scanner tomato = new Scanner(System.in);                                                                                                                                                                   
    double[] marks = new double[10];
    String[] names = new String[10];
    double max;                                                                                                                                                                                             
    int i;                                                                                                                                                                                                     

    for(i=0; i<3; i++) {  
         System.out.println("Enter name of student: ");                                                                                                                                                                   
        names[i] = (tomato.nextLine()); 
        System.out.println("Enter marks: ");                                                                                                                                                                   
        marks[i] = tomato.nextDouble(); 
        tomato.nextLine();
    }                         
    int position = 0;
    max = marks[i];                                                                                                                                                                                            
    for(i = 0; i < 3; i++) {                                                                                                                                                                                  
        if(max < marks[i]) {                                                                                                                                                                                   
            max = marks[i]; 
            position = i;
        }                                                                                                                                                                                                      
    }                                                                                                                                                                                                          
    System.out.println("Highest marks:"+ marks[position] + " student name " + names[position]);
}