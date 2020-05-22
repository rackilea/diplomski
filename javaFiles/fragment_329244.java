public double average()
{
     double average = 0.0;
     for (int i = 0; i < people.size(); i++)  {
         average += people.get(i).getMark() ; 
     }
     return average/people.size();
 }