Set<Dog> dogs = getDogs();
Set<Pet> pets = dogs;        // the compiler will complain here
pets.add(new Cat("Fluffy")); // to avoid letting this happen
for(Dog dog : dogs)         // which would cause an exception here
{
   ...
}