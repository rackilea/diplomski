public static void main(String[] args) {

    int year = 1900;                
    while (year <= 2100 ){

        if (year % 4 == 0){
            System.out.println(year + " Is a Leap Year");
            year++;
        }
        else {
            System.out.println(year + " Is not a leap year");
            year++;
        }
    }   

}


}