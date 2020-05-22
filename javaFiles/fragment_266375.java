public void add(Appointment a){
        if(a==null){
         throw new IllegalArgumentException("appointement can't be null");
        }
    //equals in appointement must be overrided to give correct behaviour 
    if(appointmentList!=null && appointmentList.contains(a)){
       throw new AppointementAlreadyExistException();
    }
    appointmentList.add(a);


    }