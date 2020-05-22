Fighter Lucas = new Fighter(Statistics.punchStrength, Statistics.movementSpeed, Statistics.reflex);
Opponent Simon = new Opponent(Statistics.punchStrength2, Statistics.movementSpeed2, Statistics.reflex2);

// fight
while(Lucas.isAlive()&&Simon.isAlive())
   Lucas.attack(Simon);

// report winner
if(Lucas.isAlive())
   System.out.println("winner is Lucas");
if(Simon.isAlive())
   System.out.println("winner is Simon");