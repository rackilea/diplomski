public static void main(String[] args) {
  String doubleVal = "1.745";
  String doubleVal1 = "0.745";
  BigDecimal bdTest = new BigDecimal(  doubleVal);
  BigDecimal bdTest1 = new BigDecimal(  doubleVal1 );
  bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
  bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
  System.out.println("bdTest:"+bdTest); //1.75
  System.out.println("bdTest1:"+bdTest1);//0.75, no problem
}