while (inputFile.hasNext() && counter < numFans.length)
{
    names[counter] = inputFile.nextLine();
    numFans[counter] = inputFile.nextInt();
    if (inputFile.hasNext())
        inputFile.nextLine(); // nextInt() will read a number, but not the newline after it
    System.out.println(names[counter] + ": " + numFans[counter]);
    counter++;
}