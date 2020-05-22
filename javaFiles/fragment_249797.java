String phrase="bob has a bike bob, bob and boba bob's bike is red and \"bob\" stuff.";
  String word="bob";
  phrase= phrase.replace("'","ñ").replace('"','ö');
  phrase=phrase.replaceAll("\\b" + Pattern.quote(word) + "\\b","");
  phrase= phrase.replace('ö','"').replace("ñ","'");
  System.out.println(phrase);