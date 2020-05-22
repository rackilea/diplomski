public boolean checkValues()
{
     Set<Integer> total = new HashSet<Integer>();
     for (int i=0; i< n ; i++){
        for (int j=0; j< n ; j++){
           int num = square.get(i).get(j);
           if(num>=1 && num<=n*n)
               total.add(num);
        }
     }
     if(total.size() == n*n)
        return true;
     else
        return false;
}