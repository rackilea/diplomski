int i = 0;

// note sum of two consecutive integers will never be even (never 50)
while (i + ++i < 50);

System.out.println("min increments with sum > 50 was " + (i - 1) + " and " + i);