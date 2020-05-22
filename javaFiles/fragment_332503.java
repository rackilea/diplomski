matrix = (Requirement)agent;
Iterator<Object> reqIter = matrix.getRequirements(); //iterate the rows
while (reqIter.hasNext())
{
   Object current = reqIter.next();
   enter.take( new MyAgent(current) ); //PUSH current in the top flow
}

Iterator<Object> sellIter = matrix.getRequirements(); //iterate the columns
while (sellIter.hasNext())
{
   Object current = sellIter.next();
   enter1.take( new MyAgent(current) );   //PUSH current in the bottom flow
}