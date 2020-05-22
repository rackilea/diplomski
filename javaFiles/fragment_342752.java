double sum = 0;
double average =0;
for (int i=0; i < 20; i++) {
  call.read();
  sum = sum + call.getSeconds();
}
average = sum / 20.0;
System.out.println(average);