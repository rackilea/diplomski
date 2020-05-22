String num = "16.7499924";

int digitCount = 4;
MathContext mContext = new MathContext(digitCount, RoundingMode.UP);
BigDecimal numB = new BigDecimal(num, mContext);
System.out.println("16.7499924f with MathContext(precision) of 4 =" + numB.toPlainString());
numB = numB.setScale(4, RoundingMode.UP);
System.out.println("16.7499924f with MathContext(precision) of 4 and after setScale of 4 =" + numB.toPlainString());