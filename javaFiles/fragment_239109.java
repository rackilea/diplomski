public static String howMany(Scanner chopper){
    String x = "";
    int y = 0;
    int doubleCount=0;
    int intCount =0;
    while(chopper.hasNext()){
        y++;
        if (chopper.hasNextDouble()){
            doubleCount++;
        }
        if(chopper.hasNextInt()){
            intCount++;
        }
        x = chopper.next();
    }
    return x+y+" "+ intCount + " " + doubleCount;
}