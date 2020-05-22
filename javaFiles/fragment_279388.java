struct People
{
    // struct members are public by default
    float height;
    float weight;
    int age;
}
people[10]; // array of 10 objects

int main ()
{
    // fill some data
    people[0].age = 15;
    people[0].height = 1.60;
    people[0].weight = 65;

    return 0;
}