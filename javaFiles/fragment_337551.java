String[] s = new String[4];
s[0] = "pot-1_Sam";
s[1] = "pot-22_Daniel";
s[2] = "pot_444_Jack";
s[3] = "pot_5434_Bill";
ArrayList<String> result = new ArrayList<String>();
for (String value : s) {
    String[] splitedArray = value.split("_");
    result.add(splitedArray[splitedArray.length-1]);
}

for(String resultingValue : result){
    System.out.println(resultingValue);
}