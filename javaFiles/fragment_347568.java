interface IPetHouse<out T> where T : IPet
{
    T Pet { get; }
};

class CatHouse : IPetHouse<Cat>
{
    public Cat Pet => new Cat();
}

class DogHouse : IPetHouse<Dog>
{
    public Dog Pet => new Dog();
}

// 'out' keyword gives possibility to treat CatHouse and DogHouse as IPetHouse<IPet> since IPet is less derived type
var petHouses = new IPetHouse<IPet>[] {
    new CatHouse(), 
    new DogHouse()
};

// Types are preserved, which you can check easily 
petHouses.Select(ph => ph.Pet.GetType().Name); //outputs: Cat and Dog