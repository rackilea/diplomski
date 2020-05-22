public CoffeeMachineImplementation() throws IOException {
        maWaterCap = 5;
        maCoffeeCap = 3;

        setScannerInstance(new Scanner(System.in));
    }

void setScannerInstance(Scanner s){
   this.sc = sc;
}

String getExceptionMessage(String propKey, Double value){
   return MessageFormat.format(prop.getProperty(propKey), value);
}

Properties getProperties(){
    if(prop == null){
       prop = new Properties();
       input = new FileInputStream("src/localization.properties");
       prop.load(input);
    }

    return prop;
}


public double insertCash() throws InvalidCoinException {
    double cash = 0;
    double temp; // temporary variable which goes through all if statems if all conditions are satisfied it gets assigned to cash variable
    boolean coinExists = false;
    System.out.println(getProperties().getProperty("insert.cash"));

    if(!sc.hasNextDouble()) {
        throw new InvalidCoinException(getExceptionMessage("invalid.coin", sc.next()));
    }