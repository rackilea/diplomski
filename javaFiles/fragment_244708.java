for (int n = 0; n < list.size(); ++ n) {
   String s = list.get(n);
   sb.append(s); 
   if (n % 2 == 1) // append a comma after odd elements
      sb.append(",");
}