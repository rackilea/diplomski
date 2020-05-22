do{
          s=new Student();
          System.out.println("Please Enter Your Student ID (type quit to Quit):\n");
          studentNumber=keybrd.next();
          if(studentNumber.equals("quit"))
              break;
          s.setStudentNumber(studentNumber);
          System.out.println("Please Enter Your Course ID:\n");
          course=keybrd.next();
          s.setCourse(course);
          System.out.println("Please Enter Your Mark:\n");
          mark=keybrd.nextInt();
          s.setMark(mark);
          s.printStates();
          studentsCourses.add(s);
        }while(true);