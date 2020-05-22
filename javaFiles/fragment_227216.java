public class Container implements Serializable {
    private List<Item> elements;
    [... some other fields ...]
}

public abstract class Item implements Serializable {}

public class A extends Item {
    ...
}

public class B extends Item {
    ...
}

public class C extends Item {
    ...
}

...

Moshi moshi = new Moshi.Builder()
    .add(PolymorphicJsonAdapterFactory.of(Item.class, "item_type")
        .withSubtype(A.class, "a")
        .withSubtype(B.class, "b")
        .withSubtype(C.class, "c"))
    .build();
containerAdapter = moshi.adapter(Container.class);