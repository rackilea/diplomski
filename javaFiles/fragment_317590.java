Public String getGrade(double expensesToIncome){
  //Calculate grade based on expenses to income ratio
  String myGrade = "A";

  if (expensesToIncome<0.25) {
      myGrade = "A";
  }
  return myGrade;
}