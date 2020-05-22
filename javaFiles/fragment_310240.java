int i = 0;
for (int index = 0; index < pointData.length; index++)
{
      //Add the data from pointData to the index
      averages[i] += pointData[index];
      //if seven scores have been added
      if(index % 7 == 6) {
         //divide by seven to get average
         averages[i] = averages[i]/7.0;
         i++;
      }
}