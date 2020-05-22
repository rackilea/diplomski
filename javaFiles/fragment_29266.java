class Person{  
       int id; 
       String studentName;  
       // a static variable 
       static String collegeName ="MBA";  

       Person(int i,String n)
       {  
        id = i;  
        studentName = n;  
       }  

        void output ()
        {
         System.out.println(id +" "+ studentName +" "+ collegeName);
        }  

     public static void main(String args[])
       {  
        Person student1 = new Person(100,"Joe");  
        Person student2 = new Person(200,"Jef");  

        student1.output();
        student2.output(); 
       }  
    }  

Display:
     100 Joe MBA
     200 Jef MBA