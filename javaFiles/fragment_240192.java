public static void question2()
   {
      Pattern p = Pattern.compile("one|two");
      Map<String, String> replacements = new HashMap<String, String>();

      replacements.put("one", "1");
      replacements.put("two", "2");

      StringBuffer result = new StringBuffer();

      String text = "one ... two";

      Matcher m = p.matcher(text);

      while (m.find())
      {
         m.appendReplacement(result, replacements.get(m.group()));
      }

      m.appendTail(result);

      System.out.println(result.toString());

   }