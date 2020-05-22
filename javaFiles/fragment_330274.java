for (PersonalInformation  individual : arr) {
    if(individual != null && "Full-Time Faculty".equals(type) ) { // constant left : variable right !  
        if(individual instanceof FullTimeFaculty){ 
            individual.showInfo();
        } else {
            System.err.println("not FullTimeFaculty");
        }
    } else {
        System.err.println("null or not Full-Time Faculty");
    }
}