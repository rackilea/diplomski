int iterationCount = 0;
while (num != 0) {
    System.out.println("Before iteration="+iterationCount+" num="+num+" rev="+rev);
    int rmd = num % 10;//the remainder of 252 is 2
    rev = rev * 10 + rmd;//rev which is 0 multiplied by 10 is 0 + 2 is 2
    num = num / 10;
    System.out.println("After iteration="+iterationCount+" num="+num+" rev="+rev);
    iterationCount++;
}