public static String m(Map<String, String> mp)
{
   String str = "{"
      + " \"SomeAttribute\": "
      + "{";

   for (Map.Entry<String, String> pair : mp.entrySet())
   {
      str += "\"" + pair.getKey() + "\": \"" + pair.getValue() + "\",";
   }

   str += "}"
      + "}";

   return str;
}