int count = 0;
if(a < 0)
    count++;
if(b < 0)
    count++;
if(c < 0)
    count++;

if(count % 2 == 1)
    System.out.println("Negative");
else
    System.out.println("Positive");