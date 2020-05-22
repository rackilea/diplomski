boolean firstkill = true;
int firsthitpoints = 0; // <-- declare and initialize.
while (firstkill) {
    if (firstattack > firstenemydefense){
        firsthitpoints = Math.ceil(Math.random() * firstbattleattack);
    }
    int firstenemynewhealth = firstenemyhealth - firsthitpoints;
    // ...