protected Object clone() throws CloneNotSupportedException
{
    DogTail tail = (DogTail) this.tail.clone();

    Dog dog = (Dog) super.clone();

    dog.tail = tail;

    return dog;
}