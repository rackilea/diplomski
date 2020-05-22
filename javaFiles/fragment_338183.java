//test data
    LocalDate startDate = LocalDate.now(); //get current date
    LocalDate endDate = startDate.plusDays(5); //add 5 days to current date

    System.out.println("startDate : " + startDate);
    System.out.println("endDate : " + endDate);

    for(LocalDate currentdate = startDate; 
            currentdate.isBefore(endDate) || currentdate.isEqual(endDate); 
            currentdate= currentdate.plusDays(1)){
        System.out.println(currentdate);
    }