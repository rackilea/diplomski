String input="My name is %name% and I am %age% years old.";
Matcher matcher = Pattern.compile("%(\\w+)%").matcher(input);
String output=new String(input);
while (matcher.find()) {
          System.out.println("------------------------------------");
          System.out.println("Back reference:" + matcher.group(1));
          String group=matcher.group(1);//give access to the first matching group so that it can be reused
          output=output.replaceAll("%"+group+"%", getVar(group));
       }

System.out.println(output);