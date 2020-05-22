if (matrix [3][5]== 3) {
   System.out.println("Closed");
   if (isOpen)
   {
        isOpen=false;
        System.out.println("Runtime: " + (System.nanoTime() - startTime));
   }
}
else {
   if (!isOpen)
   {
        startTime=System.nanoTime();
        isOpen = true;
        System.out.println("Opened");
   }
}