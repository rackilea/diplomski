int sum=0;
for (int i = 0; i < values.length; i++) {
    sum = sum + Integer.valueOf(values[i]);
}
hello.setValues(values);
hello.setSum(sum);