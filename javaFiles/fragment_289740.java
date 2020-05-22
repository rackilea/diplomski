DecimalFormat df = new DecimalFormat();
df.setMaximumFractionDigits(300);
df.setGroupingUsed(false);
for(double d = 1 ; d <= 1e30; d *= 1e5) {
    System.out.println(df.format(d/1e15)+"E15");
}