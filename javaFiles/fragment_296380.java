ArrayList<String> strings = new ArrayList<String>();
  ArrayList<StringBuilder> stringBuilders = new ArrayList<StringBuilder>();
  for(int i = 0; i < 1000; i++) strings.add("Remove the word remove from String "+i);
  for(int i = 0; i < 1000; i++) stringBuilders.add(new StringBuilder(i+" Remove the word remove from String "+i));
  Pattern pattern = Pattern.compile("\\w+\\s");

  // StringBuilder method
  before = System.currentTimeMillis();
  for(int i = 0; i < 5000; i++){
      for(StringBuilder s : stringBuilders){
          s.delete(0, s.indexOf(" ") + 1);
      }
  }
  after = System.currentTimeMillis() - before;
  System.out.println("StringBuilder Method Took "+after);

  // Substring method
  before = System.currentTimeMillis();
  for(int i = 0; i < 5000; i++){
      for(String s : strings){
          String newvalue = s.substring(s.indexOf(" ") + 1);
      }
  }
  after = System.currentTimeMillis() - before;
  System.out.println("Substring Method Took "+after); 

  //Split method
  before = System.currentTimeMillis();
  for(int i = 0; i < 5000; i++){
      for(String s : strings){
          String newvalue = s.split(" ", 2)[1];
          System.out.print("");
      }
  }
  after = System.currentTimeMillis() - before;
  System.out.println("Your Method Took "+after);

  // Regex method
  before = System.currentTimeMillis();
  for(int i = 0; i < 5000; i++){
      for(String s : strings){
          String newvalue = pattern.matcher(s).replaceFirst("");
      }
  }
  after = System.currentTimeMillis() - before;
  System.out.println("Regex Method Took "+after);