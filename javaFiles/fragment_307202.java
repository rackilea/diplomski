try { 
   findANDclick(new String[]{"id", "menuButton"});
   findANDclick(new String[]{"src", ".*homeicon_calendar.*"});    
   findANDclick(new String[]{"src", ".*cycle_templates.*"});   
} catch (Exception e) {
   // Workup exception somehow.
}