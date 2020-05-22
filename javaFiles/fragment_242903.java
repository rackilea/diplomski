// one constructor
HouseCat(){
    this.cType = "Short Hair";
}

// another constructor
public HouseCat(String name, double weight, String mood, String cType) {
    super(name, weight, mood);
    if(cType.equalsIgnoreCase("Short Hair")||cType.equalsIgnoreCase("Bombay")||cType.equalsIgnoreCase("Ragdoll")||cType.equalsIgnoreCase("Sphinx")||cType.equalsIgnoreCase("Scottish Fold")) {
        this.setCType(cType);
    }
    else {
        System.out.println("Invalid type");
    }
}