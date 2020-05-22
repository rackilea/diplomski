BigDecimal sum = BigDecimal.ZERO;
for (int i = 0; i < select.length; i++) 
{
   sum = sum.add(new BigDecimal(select[i]));
}
out.println(sum);