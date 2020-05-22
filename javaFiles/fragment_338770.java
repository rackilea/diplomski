@Embeddable
class Coordinates{
    int x;
    int y;
}

@Entity
class Person{
    String name;
    @Embedded
    Coordinates coordinates;
}