public static void main(String[] args) {

    String[] cars = {"honda", "toyota", "honda", "toyota"};
    String[] honda = new String[5];
    String[] toyota = new String[5];
    int numOfHonda = 0;  // you need to initialize these int variables
    int numOfToyota = 0;

    for (int i = 0; i < cars.length; i++) {
        if (cars[i].equals("honda")) { // if cars has element honda
            honda[i] = cars[i];        // putting cars element in honda array
            numOfHonda++;             //incrementing value of numOfHonda by 1
        }
        else if(cars[i].equals("toyota")){
        toyota[i] = cars[i];
        numofToyota++;

    }
 }