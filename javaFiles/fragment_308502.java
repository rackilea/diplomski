public class someOtherClass {
    //how can I access the variables in MonsterStats
    // that were just set by Monsters???

Monster mnstr = new Monster();
MonsterStats stats = mnsrt.getMonsterStats();
stats.getName();
............
}

public class Monster {

public MonsterStats monsterStats;

...processXML pseudo code...
monsterStats.name = xml.monsterName;
monsterStats.type = xml.monsterType;
monsterStats.race = xml.monsterRace;
...etc...



public MonsterStats getMonsterStats()
{
.....
return monsterStats;
}

}


public class MonsterStats {
//encounter info
public String name = "";
public String type = "";
public String race = "";
public String gender = "";
public String alignment = "";   
public int age = 0;

public String getName()
{
return name;
}
}