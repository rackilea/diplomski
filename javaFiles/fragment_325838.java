byte[] bytes = word.getBytes(); 
int sum = 0;
for (int i = 0; i < length; i++) {
    sum += bytes[i];
}
System.out.println("the ascii sum is " + sum);