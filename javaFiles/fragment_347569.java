interface IPetHouse<in T> where T : IPet
{
    void AddPet(T pet);
};

class PetHouse : IPetHouse<IPet>
{
    public void AddPet(IPet pet)
    {
    }
}

class CatHouse : IPetHouse<Cat>
{
    public void AddPet(Cat pet)
    {
    }
}

// 'in' keyword gives possibility to treat PetHouse as a CatHouse, since Cat is more derived type
IPetHouse<IPet> petHouse = new PetHouse();
IPetHouse<Cat> catHouse = petHouse;
catHouse.AddPet(new Cat()); // requires Cat to be passed