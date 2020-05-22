while (endOfFile != true)
    {
        try
        {

             Student tempStudent = (Student) studentStream.readObject();
             stud1.add(tempStudent);
        }