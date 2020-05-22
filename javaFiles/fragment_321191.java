public static List<Number> collectNums(Object nrAry[][])
{
   List<Number> numbers = new ArrayList<Number>();
   for(int i=0;i < nrAry.length; i++)  {
       for(int j=0;j < nrAry[i].length; j++) {
            if (nrAry[i][j] instanceof Number)  {
                numbers.add((Number)nrAry[i][j]);
            }
        }
    }
    return numbers;
}