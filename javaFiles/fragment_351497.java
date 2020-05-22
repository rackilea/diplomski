if(sc.hasNext()) {
   int i = sc.nextInt();
   answer = i + "";
   sum += i;
   while(sc.hasNext())
      {
          i = sc.nextInt();
          answer = answer + " + " + i;
          sum = sum + i; 
      }
}