public class fibIterative {

  public int AfibIterative (int num)
  {
    int i = 1;
    int j = 0;

    for (int k = 1; k < num; k++)
    {
         j = i + j;
         i = j - 1;
    }
    return j;   
  }

}