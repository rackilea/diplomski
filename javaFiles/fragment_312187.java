try
{
   Wini ini = new Wini(new File(PROP_FILE));
   ini.put("others", "prop5", value); // "others" is the section, "prop5" the key, and "value" is self-explanatory.
   ini.store(); // INI file is saved
}
catch (IOException e)
{
   // log problem... do whatever!
}