NotesAPITest nat = new NotesAPITest();
        NotesThread.sinitThread();

        Session sess1 = NotesFactory.createSession();
        System.out.println(sess1.getUserName());
        Database database = sess1.getDatabase("", "mailfile");
        View calendarView = database.getView("($Calendar)");
        DateTime dt = sess1.createDateTime("today");
        ViewEntryCollection vec = calendarView.getAllEntriesByKey(dt, true);

        ViewEntry entry = vec.getFirstEntry();
         while (entry != null) 
         {

           Document caldoc = entry.getDocument();

           System.out.println("Subject: " + caldoc.getItemValueString("Subject"));
           System.out.println("Chair Person: " + caldoc.getItemValueString("Chair"));
           System.out.println("Start Time: " + nat.getStartEndTimes(caldoc, "StartDateTime") );
           System.out.println("Start Time: " + nat.getStartEndTimes(caldoc, "EndDateTime") );
           System.out.println("Required: " + caldoc.getItemValueString("RequiredAttendees"));
           entry = vec.getNextEntry(); 
         }