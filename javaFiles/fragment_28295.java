do
{
    System.out.println("\nEnter scale factor");
    scale = input.nextDouble();
    System.out.println("Scale entered was: " + scale);
    System.out.println("Is scale < 0? " + (scale < 0));
}
while(scale < 0);