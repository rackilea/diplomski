Set<Animal> animalSource = ...;
Set<Animal> animalTarget = ...;
Set<String> animalFilterName = ...;

// add matching animals to new set
for (Animal a : animalSource)
    if (animalFilterName.contains(a.getName())) animalTarget.add(a);

// if you need to remove them from the first set, uncomment these lines
// for (Animal a : animalTarget)
//     animalSource.remove(a);