Student student = new Student("Souid","Ayoub","ayoub@luv2code.com");
        Student student2 = new Student("Test Student","TestStudent","test@mail.com");

        //start the transaction
        session.beginTransaction();

        //save the object
        System.out.println("Saving the Student...");
        session.save(student);
        session.save(student2);
        .....