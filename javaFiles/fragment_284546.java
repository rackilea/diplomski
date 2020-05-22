public static Athlete findAthleteByName(Athlete[] athletes, String name){
    for(int i=0; i<athletes.length; i++){
        if(name.equals(athletes[i].getName()))
            return athletes[i];
    }
    return null;
}