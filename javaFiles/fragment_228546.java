int lineIdx =0;
while (infile.hasNextLine() && lineIdx < 12)
{
 lname[lineIdx] = infile.next();
 fname[lineIdx] = infile.next();
 income[lineIdx] = infile.nextDouble();
 lineIdx++;
}//while