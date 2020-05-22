if(test.length() > 50){
    int comma = test.indexOf(',', 50);
    if(comma >= 0){

        //Bit before comma
        String partOne = test.substring(0, comma);

        //Bit after comma
        String partTwo = test.substring(comma);

        //Do Something
    }
}