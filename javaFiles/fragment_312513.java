public class MyTest {

    @Test
    public void myTest() throws JsonProcessingException {
        final FixedContentsCase fcc = new FixedContentsCase();
        fcc.setId(Long.valueOf(1));
        final Item item = new Item();
        item.setId(Long.valueOf(2));
        item.setDescription("item 1");
        fcc.getItems().add(item);
        final ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(fcc));
    }
}

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
class Item extends StorageUnit {

    ...
}

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
class FixedContentsCase extends StorageUnit {

    ...
}

abstract class StorageUnit {

    ...
}