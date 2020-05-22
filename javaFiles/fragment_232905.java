public static void main(String[] args) {

    int year = 1900;                
    while (year <= 2100 ){
            System.out.println(year + " Is "+ ((year % 4 == 0)? "" : "not")+" a Leap Year");
            year++;

    }   

}