public void alwaysThrow()
{
    throw new RuntimeException();
}

...

alwaysThrow();
System.out.println("This line is never reached");