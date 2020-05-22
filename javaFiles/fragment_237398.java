int totalWeight = 0;
for (Foo foo : list)
{
    totalWeight += foo.getWeight();
}

// As usual, normally you'd reuse an existing instance
Random rng = new Random();
int value = rng.nextInt(totalWeight);

// Pick an item based on the random value we've chosen
for (Foo foo : list)
{
    if (value < foo.getWeight())
    {
        return foo;
    }
    value -= foo.getWeight();
}