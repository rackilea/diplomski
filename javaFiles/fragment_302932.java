count1 = rgen.nextInt(number);
for(int x=0; x<count1; x++) {
  system.out.print("*");
}
system.out.println(count1);    

count2 = rgen.nextInt(number-count1);
for(int x=0; x<count2; x++) {
  system.out.print("*");
}
system.out.println(count2);

count3 = number-(count1+count2);
for(int x=0; x<count3; x++) {
  system.out.print("*");
}
system.out.println(count3);