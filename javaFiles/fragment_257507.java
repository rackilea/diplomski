if()
{
}
else if()
 {
 }
else  {
    Team t1 = new Team("Day 1: Chest, Shoulders and Triceps");
    t1.players.add("Bench Press – 3 sets of 10, 10, 8 (adding weight) reps");
    t1.players.add("Incline Dumbbell Bench Press – 3 sets of 10 reps");
    t1.players.add("Chest Dip – 3 sets of MAX reps");
    t1.players.add("Skullcrushers – 3 sets of 8-10 Reps");
    t1.players.add("One Arm Dumbbell Extension – 3 sets of 10 reps");
    t1.players.add("Tricep Extension – 3 sets of 10 reps");
    t1.players.add("Barbell Front Raise – 4 sets of 12 reps");
    t1.players.add("Dumbbell Lateral Raise – 4 sets of 15, 12, 8, 8 (adding weight) reps");
    ArrayList<Team> allTeams = new ArrayList<Team>();
    allTeams.add(t1);       
    return allTeams;
}