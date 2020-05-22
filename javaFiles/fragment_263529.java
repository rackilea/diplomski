for(double difference : listOfDifferences)
{
    double square = difference * difference ;
    listOfDifferences.add(difference);
    squares.add(square);
    System.out.printf("%4.2f", square);
    System.out.printf(" "); 
}