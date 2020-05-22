public static void main(String[] args)
             {
BubbleSort bs = new BubbleSort(); //name of your class instead of BubbleSort

    double[] r1Array = {intJ1R1, intJ2R1, intJ3R1, intJ4R1, intJ5R1, intJ6R1};
    double[] r2Array = {intJ1R2, intJ2R2, intJ3R2, intJ4R2, intJ5R2, intJ6R2};

         double[] sortedR1 = bs.bubbleSort(r1Array);   
         double[] sortedR2 = bs.bubbleSort(r2Array); 

            }
     public double[] bubbleSort(double[] array){
    double temp;

         for (int i=0; i<array.length; i++)
        {
            for (int j = 1; j <(array.length-i); j++)
            {
                if (array[j-1]>=array[j])
                {
                    temp=array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        } 
         return array;
        }