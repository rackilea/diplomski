public Sport createSportPerformanceInstance(String name, Attributes attributes) 
{
if (name.equalsIgnoreCase("football"))
    {return new BasketballPerformance(attributes);}
else 
if (name.equalsIgnoreCase("baseball"))
    {return new BaseballPerformance(attributes);}
...
}


public void load(String localName, String qName, Attributes attributes) 
{
SportPerformance sportPerformance = this.createSportPerformanceInstance(localName, attributes);
Player player = new Player(Attributes attributes);
player.sportPerformance = sportPerformance;
}