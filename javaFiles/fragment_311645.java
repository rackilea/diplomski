if (localName.equalsIgnoreCase("football"))
 player.category = "football"
 player.TouchDowns=attributes.getValue("TouchDowns");

else if (localName.equalsIgnoreCase("baseball"))
  player.HomeRuns=arrtibutes.getValue("HomeRun");
  player.category = "baseball"

else{
  player.category = "basketball";
  player.Points=attributes.getValue("Points");}