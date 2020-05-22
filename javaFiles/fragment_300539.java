public void doAddEntry(Entry entry) throws Exception {
    if (entry == null)
    {
      //save file here..
      doSave(); 
    }
    else if (length == 200) {
    //save file here..
    doSave(); 
    throw new Exception("I'm full");
   }
   else
   {
    boolean matched = false;
    for (int i = 0; i<length; i++) {
    if (entryList[i].name.compareToIgnoreCase(entry.name) == 0) {
      matched = true;
      break;
    }
    if(!matched)
    {
      entryList[entryList.length] = entry;
    }
   }
}