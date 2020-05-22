public void Post() 
{
     double Temp = 0;
     int K;
     for(K = 0; K < Count ; K++) {
         System.out.print(" " + List[K].GetLocation() + ": ");
         System.out.println("Enter Temperature");
         Temp = Input.nextDouble();
     }
}