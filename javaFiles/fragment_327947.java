while(input.hasNext()) {
     int courseId = 0;
     if(input.hasNextInt()) courseId = input.nextInt();
     input.nextLine();
     String datesOfCourse = input.nextLine();
     String courseName = input.nextLine();
     String courseDescription = input.nextLine();
     int courseLimit = 0;
     if(input.hasNextInt()) courseLimit = input.nextInt();
      System.out.println("Course ID: " + courseId + ", " + "Dates of course: " +  datesOfCourse + ", " +
                "Name of Course: " + courseName + ", " + "Course Description: " + courseDescription + ", " +
                "Course Limit: " + courseLimit);
    }