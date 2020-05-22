// Do this wherever you have easy access to the file name
Map<Star,Integer> star_number = new HashMap<Star,Integer>();
star_number.put(star1,1);
star_number.put(star2,2);
etc...

//Then later...
boolean collided(Star star, Integer expectedAnswer){
    Integer answerGiven = star_number.get(star);
    return expectedAnswer.equals(answerGiven);
}