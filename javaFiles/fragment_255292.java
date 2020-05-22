Loan m = new Loan();
Circle n = new Circle();
List<Object> list = new ArrayList<Object>();
list.add(m);
list.add(n);

for(Object b : list){
  if(b instanceof Loan){
   Loan nLoan = (Loan)b;
  }
}