import java.io.InputStream;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

class Main {

    public static void main(String[] args) throws Exception {
        Serializer serializer = new Persister();
        InputStream source = ClassLoader.getSystemResourceAsStream("myxml.xml");
        ItemSearchResponse itemSearchResponse = serializer.read(ItemSearchResponse.class, source);
    }
}

@Root
class ItemSearchResponse {
    @Element(name = "Items")
    Items items;

    @Element(name = "OperationRequest")
    String operationRequest;
}

class Items {

    @Element(name = "Request")
    Request request;

    @Element(name = "TotalPages")
    int totalPages;

    @ElementList(inline = true, name = "Item")
    List<Item> itemList;
}

class Request {

    @Element(name = "IsValid")
    boolean isValid;
}

@Root(name = "Item")
class Item {

    @Element(name = "DetailPageURL", required = false)
    String url;
}