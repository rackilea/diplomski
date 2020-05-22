Random r = new Random();

...
void yourFunction()
{
  float chance = r.nextFloat();

  if (chance <= 0.10f)
    doSomethingLucky();
}