...
System.out.println("Enter value to find");
search = in.nextInt();

boolean exists = false;

for (c = 0; c < n; c++)
{
  if (array[c] == search)     /* Searching element is present */
  {
     System.out.println(search + " is present at location " + (c + 1) + ".");
     exists = true;
  }
}

if (!exists)  /* Searching element is absent */
  System.out.println(search + " is not present in array.");