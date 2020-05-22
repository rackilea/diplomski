public class DailyCatch
{
  private int fishermanID, fisherID;
  private String dateOfSample, date;
  private double[] fishCaught = new double[10];
  private int currWeight = 0;

  public DailyCatch() {  }

  public DailyCatch (int fishermanID, String dateOfSample)
  {
    fisherID = fishermanID;
    date = dateOfSample;
  }

  public DailyCatch (int fishermanID, String dateOfSample, String weight)
  {
    this(fishermanID, dateOfSample);
    readWeights(weight);
  }

  public void addFish(double weight)
  {
    if (currWeight > 10)
    {
       // array full
    }
    else
    {
      fishCaught[currWeight] = weight;
      currWeight += 1;  // update current index of array
    }
  }

  private void readWeights(String weightsAsString) 
  {
    String[] weightsRead = weightsAsString.split("\\s+");
    for (int i = 0; i < weightsRead.length; i++) 
    {
       this.addFish(Double.parseDouble(weightsRead[i]));
    }
  }

  public String toString()
  {
    return "Fisherman ID: " + fisherID + "\nDate:" + date + "\nWeights: " + Arrays.toString(fishCaught);
  }

  public void printWeights()
  {
     for (int i = 0; i < fishCaught.length; i++)
     {
          System.out.println(fishCaught[i]);
     } 
  }
}