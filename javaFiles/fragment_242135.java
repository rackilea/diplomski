double sumPiOverMTrials = 0;
for( int m=0; m<10; m++)
{
  double hits = 0;
  for (int i = 0; i < numThrows; i++) { 
    double xPosition = (randomGen.nextDouble()) * 2 - 1.0;
    double yPosition = (randomGen.nextDouble()) * 2 - 1.0;
    if (ifitisInside(xPosition, yPosition))
    {
      hits++;
    }
  }
  double pi = 4.0 * hits/numthrows;
  System.out.println("Trial["+m+"]: ="+ pi);
  sumPiOverMTrials += pi;
}
System.out.println("Average over "+m+" trials ="+ sumPiOverMTrials/10);