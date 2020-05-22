public static void main(String[] args) 
{ //this is where your main method starts
  ArrayList<String> projectStrings = new ArrayList<String>();
  projectStrings.add("The ");
  projectStrings.add("quick ");
  projectStrings.add("brown ");
  projectStrings.add("fox ");
  projectStrings.add("jumped ");
  projectStrings.add("over ");
  projectStrings.add("the ");
  projectStrings.add("lazy ");
  projectStrings.add("dog.");
} //this is where your main method ends
//this line is outside any method, thus you get those errors
System.out.println(projectStrings.get(1).concat(projectStrings.get(0)));
} //this is where your stringProject class definition ends