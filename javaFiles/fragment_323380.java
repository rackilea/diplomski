String line_str = "1,3,4,3,11,2,2,6,7";
String[] str_arr = line_str.split(",");
Set<Integer> uniqueNumbers = new LinkedHashSet<Integer>();
for(String num : str_arr) {
    uniqueNumbers.add(Integer.parseInt(num));
}