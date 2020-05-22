StringJoiner joiner = new StringJoiner(" + ");
while(sc.hasNext())
{
    i = sc.nextInt();
    // This automaticly includes a " + " between the values.
    joiner.add(String.valueOf(i));
    sum = sum + i; 
}