line = read.readLine();
while (line != null) {  
    StudentID = line;  
    System.out.println("StudentID = " + StudentID);  

    line = read.readLine();  
    Course = line;  
    System.out.println("Course = " + Course);  

    line = read.readLine();
    SMark = line;  
    System.out.println("Mark = " + SMark + "\n");  

    Mark = Integer.valueOf(SMark);
    if(Mark >= 50)  
    {  
        WriteToPass.println(StudentID);  
        WriteToPass.println(Course);  
        WriteToPass.println(SMark);  
    }  
    else  
    {  
        WriteToFail.println(StudentID);  
        WriteToFail.println(Course);  
        WriteToFail.println(SMark);  
        WriteToFail.println(line);  
    }  
    line = read.readLine();
}   
WriteToPass.close();  
WriteToFail.close();