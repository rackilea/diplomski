String my_array[];
my_array = new String[] {"1.006944444","6.45160645160", "0.00000326701", "0.0076001595"};

// then used my for loop like

BigDecimal b1 = new BigDecimal(n);
for(int 1=0;i<my_array.length;i++)
{
BigDecimal b2 = new BigDecimal(Double.parseDouble(my_array[i]));
BigDecimal result = b1.multiply(b2);
System.out.println(result.doubleValue);
}