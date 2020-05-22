resultOptional.ifPresent((Student result) -> {
   if(studentDetails.getPhoneNumber()!=null) {
     result.getStudentDetails().setPhoneNumber(studentDetails.getPhoneNumber());     
   }
   if(studentDetails.getLastname()!=null) {
     result.getStudentDetails().setLastname(studentDetails.getLastname());
   }
   studentRepository.save(result);
});