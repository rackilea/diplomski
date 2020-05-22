import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class JAXBTest {

    @Test
    public void xmlIsUnmarshalled() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Items.class);
        Unmarshaller um = context.createUnmarshaller();
        Items items = (Items) um.unmarshal(new File("items.xml"));

        assertNotNull(items);
        assertNotNull(items.getItems());
        assertEquals(2, items.getItems().size());

        assertEquals("Chinos", items.getItems().get(0).getDescription());
        assertEquals("Trousers", items.getItems().get(1).getDescription());

        assertEquals("1", items.getItems().get(0).getId());
        assertEquals("2", items.getItems().get(1).getId());
    }
}