/* Declare it here */
Players Character = null;

if(...) {
/* Do Something Here */
} else if (in.equals("Monster") && in1.equals("Orc")) { 
    Character = new Orc();
    System.out.println("You have chosen " + in + " type " + 
                       in1 + ". Monsters in general are more attack orientated");
}

/* Now you can use it here */
Character.addAttack(5);