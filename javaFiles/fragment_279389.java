package Example;

private class People
{
    // define members as public
    public float height;
    public float weight;
    public int age;
}

class Main
{
    public static main (String [] args)
    {
        // array of 10 references
        People [] p = new People [10];

        // allocate an object to be referenced by each reference in the array
        for (int i=0; i<10; i++)
        {
            p[i] = new People();
        }

        // fill some data
        people[0].age = 15;
        people[0].height = 1.60;
        people[0].weight = 65;
    }
}