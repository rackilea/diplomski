Student student = new Student();
  EnrolledInfo enrolledInfo = new EnrolledInfo(); 
  enrolledInfo.setPaidTuition(true);
  enrolledInfo.setStudent(student);

  student.setEnrolledInfo(enrolledInfo);        
  studentDao.save(student);