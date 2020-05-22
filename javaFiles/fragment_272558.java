ArrayList<String> input=new ArrayList<String>();
input.add("O 2");
input.add("O 2");
Map<String, Integer> map= new HashMap<String, Integer>();
for (String s:input) {
     String[] splitted=s.split(" ");
     String letter=splitted[0];
     Integer number=Integer.parseInt(splitted[1]);
     Integer num=map.get(letter);
     if (num==null) {
         map.put(letter,number);
     }
     else {
         map.put(letter,number+num);
     }
}
for (Map.Entry<String, Integer> entry : map.entrySet()) {
     System.out.println(entry.getKey() + " " + Integer.toString(entry.getValue()));
}