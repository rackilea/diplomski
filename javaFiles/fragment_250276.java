PairOfDice[] result = new PairOfDice[g];

// setting
for (int i = 0; i < g; i++)
{
   result[i] = new PairOfDice();
}

// printing
for (PairOfDice r : result)
{
   System.out.println(r.getDie1() + " " + r.getDie2());
}