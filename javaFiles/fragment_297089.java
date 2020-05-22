private void calculateOverall(){//new method to write
   this.overall = this.number1*this.number2+2;
}

public void setNumber1(int number){//modified setter method
   this.number1 = number;
   calculateOverall();//calculate the variable afresh when setting values
}

public void setNumber2(double number){//modified setter method
   this.number2 = number;
   calculateOverall();//calculate the variable afresh when setting values
}