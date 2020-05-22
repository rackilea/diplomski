private static DecimalFormat df = new DecimalFormat("#.##");
 //......
    @Override
    public String toString(){
      return "Name: "+getName()+
             "\nCompute Pay: "+df.format(getComputePay())+"\n";
    }