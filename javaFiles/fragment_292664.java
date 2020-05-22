public class DoCalc extends Thread
{
  public Matrix localM;
  int startRow;
  int endRow;
  public DoCalc(Matrix mArg, int startArg, int endArg)
  {
    localM=mArg;
    startRow=startArg;
    endRow=endArg;
  }

  public void doCalc()
  {
    //Pseudo-code
    for each row from startRow to endRow
      for each column 0 to size-1
        result[i][j] = similarityCalculation
  }
  public void run()
  {
    doCalc();
  }
}

public void transform(Matrix toBeTransformed)
{
  int numDocs = termDocumentMatrix.getColumnDimension();

  Main.similarityMatrix = new Matrix(numDocs, numDocs);
  Vector<DoCalc> running = new Vector<DoCalc>();
  int blockSize = 10;
  for (int x = 0; x < numDocs-1;x+=blockSize)
  {
    DoCalc tempThread = new DoCalc(toBeTransformed,x,(x+blockSize>numDocs-1)?numDocs-1:x+blockSize);
    tempThread.start();
    running.add(tempThread);
  }

  for (DoCalc dc : running)
    dc.join();

}