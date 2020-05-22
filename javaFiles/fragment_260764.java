@Entity
public class Animal {
    ....
    @PostPersist
    protected void postPersistAnimal() { .... }
}

@Entity
@EntityListeners(PetListener.class)
public class Pet extends Animal {
    ....
}

@Entity
@EntityListeners({CatListener.class, CatListener2.class})
public class Cat extends Pet {
    ....
}

public class PetListener {
    @PostPersist
    protected void postPersistPetListenerMethod(Object pet) { .... }
}

public class CatListener {
    @PostPersist
    protected void postPersistCatListenerMethod(Object cat) { .... }
}

public class CatListener2 {
    @PostPersist
    protected void postPersistCatListener2Method(Object cat) { .... }
}