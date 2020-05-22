protected Super(String[] result) {
    setA(result[0]);
    setB(result[1]);
    setC(result[2]);
    setD(result[3]);
    setE(result[4]);
}

protected Super(String d) {
    this(d.split(","));
}

...
private Sub(String[] result) {
    super(result);
    setF(result[5]);
    setG(result[6]); 
}

public static Sub fromString(String d) {
    return new Sub(d.split(","));
}