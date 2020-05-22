public static void main(String[] args) {
    // TODO code application logic here

    ArrayList<Student> studs = new ArrayList<Student>();
    for(int i=0; i< 3; i++)
    {
        studs.add(new Student());
    }

    Scanner tomato = new Scanner(System.in);                                                                                                                                                                   

    double max;                                                                                                                                                                                             
    int i;                                                                                                                                                                                                     

    for(i=0; i<3; i++) {  
         System.out.println("Enter name of student: ");                                                                                                                                                                   
        studs.get(i).setName(tomato.nextLine()); 
        System.out.println("Enter marks: ");                                                                                                                                                                   
        studs.get(i).setMark(tomato.nextDouble()); 
        tomato.nextLine();
    }                         
    int position = 0;
    max = studs.get(0).getMark();                                                                                                                                                                                            
    for(i = 0; i < 3; i++) {                                                                                                                                                                                  
        if(max < studs.get(i).getMark()) {                                                                                                                                                                                   
            max = studs.get(i).getMark(); 
            position = i;
        }                                                                                                                                                                                                      
    }                                                                                                                                                                                                          
    System.out.println("Highest marks:"+studs.get(position).getMark() + " student name " + studs.get(position).getName());
}