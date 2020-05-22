public  Object[][] geCodes(){
    Object [][] Matrix{
        {"Toyata","Fortuner","Price", "tuesday", "deliver", "Working"},
        {"Ford","Classic ","Price", "Wedday", "Not Deliver", "Working"}, 
        {"Tata","Jaguar","Price", "Satday", "deliver", "Working" }
        {"Farari","etc","Price", "sunday", "deliver", "NotWorking" }};


    Object[][] Diagonal1= new Object[2][6];
    Diagonal1[0] = Matrix[0];
    Diagonal1[1] = Matrix[2];

    return matrix; // I don't know why you are returning matrix, 
                   // you probably should be returning the new array, Diagonal1

}