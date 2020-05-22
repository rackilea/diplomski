boolean mod3 = i % 3 == 0;
boolean mod7 = i % 7 == 0;
if (mod3 && mod7) {
    System.out.printf("%d is divisible by 3 and 7.%n", i);
} else if (mod3 || mod7) {
    System.out.printf("%d is divisible by 3 or 7 (but not both).%n", i);    
} else {
    System.out.printf("%d is not divisible by 3 or 7.%n", i);       
}