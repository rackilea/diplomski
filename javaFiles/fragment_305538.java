class Config {
    double Rmax;
    double Rmin;
    // add more fields here.
}

Config config = new Config;
    while ((strLine = br.readLine()) != null) {
    //splits to variable name, value
    String[] parsed = phrase.split("=");
    try {
       String name = parsed[0];
       double value = Double.parseDouble(parsed[1]);
       Config.class.getField(name).setDouble(value);
    } catch (Exception e) {
       // log exception.
    }
}