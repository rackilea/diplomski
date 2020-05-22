List<String> inputSrings = new ArrayList<String>();
List<String> splitPlus = new ArrayList<String>();

inputStrings.add(input);

split(inputStrings, splitPlus);

List<String> splitQuest = new ArrayList<String>();
split(splitPlus, splitQuest, "?");

for (String s: splitQuest) {   
   // you can now set the attributes from the values in the list
   // splitPipe

   String[] attributes = s.split("\\|");
   myObject.setAttribute1(attributes[0]);
   ....
   myObject.setAttribute4(attributes[3]);
   System.out.println(myObject);
}