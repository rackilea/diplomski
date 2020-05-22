public class ZombieKillingAchievement extends Achievement {
     private final int numKills;
     public ZombieKillingAchievement(String name, int numKills) {
         this.numKills = numKills;
     }
     public boolean isSatisfied(Data userData) {
         return userData.getZombieKills() >= numKills;
     }
}

//...
registerAchievement(new ZombieKillingAchievement("Zombie Master", 100));
registerAchievement(new ZombieKillingAchievement("Zombie Tamer", 50));

//... on user data change
for ( Achievement a : registeredAchievements ) {
    if ( a.isSatisfied() ) {
        //show congratulatory message
    }
}