Map<String, Double> map = new HashMap<String,Double>()
while ((strLine = br.readLine()) != null) {
    //splits to variable name, value
    String[] parsed = phrase.split("=");
    String name = parsed[0];
    double value = Double.parseDouble(parsed[1]);
    map.put(name, value);
}