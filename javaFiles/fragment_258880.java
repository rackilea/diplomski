while (inputFile.hasNext() && counter < numFans.length)
{
    names[counter] = inputFile.findInLine("[^\\d]*").trim();
    numFans[counter] = inputFile.nextInt();
    System.out.println(names[counter] + ": " + numFans[counter]);
    counter++;
}