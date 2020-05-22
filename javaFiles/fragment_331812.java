Student tempStudent = (Student) studentStream.readObject();
         while (endOfFile != true)
        {
            try
            {

                 tempStudent = (Student) studentStream.readObject();
                 stud1.add(tempStudent);
            }