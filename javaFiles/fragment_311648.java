public void load(String localName, String qName, Attributes attributes) 
{
SportPerformance sportPerformance = this.createSportPerformanceInstance(localName, attributes);
String playerName=attributes.getValue("name");
Player player;
  if (!this.playerExists(playerName)) 
  {
     player = new Player(attributes);
  } else 
     {
       player = this.getPlayerByName(playerName);
     }
  player.addPerformance(sportPerformance);
}