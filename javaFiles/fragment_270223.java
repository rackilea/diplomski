for (Map.Entry<String, Boolean> entry : allTechs.entrySet())
{
    System.out.println(entry.getKey() + "/" + entry.getValue());
    allTechs.put(entry.getKey(), false);
}

for (Iterator<String> i = techs.iterator(); i.hasNext();) {
    String item = i.next();
    // possibly unsafe; we haven't checked to make sure 
    // that the "tech" is a valid one for our list
    allTechs.put(item, true); 
}