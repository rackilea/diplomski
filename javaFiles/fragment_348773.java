public int recur(int count) {
   if (count < 10) {
       return count + recur(count++);
   }
   return count;
}

System.out.println(recur(0));  // Invoke first time