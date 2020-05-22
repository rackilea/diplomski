public static String m(Map<String, String> mp)
{
   Iterator<?> it = mp.entrySet().iterator();

   String str = "{"
      + " \"SomeAttribute\": "
      + "{";

   while (it.hasNext())
   {
      Map.Entry pair = (Map.Entry) it.next();
      str += "\"" + pair.getKey() + "\": \"" + pair.getValue() + "\",";
   }

   str += "}"
      + "}";

   return str;    
}