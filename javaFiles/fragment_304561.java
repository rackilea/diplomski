import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Product")
@XmlAccessorType(XmlAccessType.FIELD)

public class Product {

  @XmlElement(name="Supplier")
  private String supplier;

  @XmlElement(name="Price")
  private String price;

  @XmlElement(name="Currency")
  private String currency;

  @XmlElement(name="Type")
  private String type;

  public Product() {

  }

  public Product(String supplier, String price, String currency, String type) {
    this.supplier = supplier;
    this.price = price;
    this.currency = currency;
    this.type = type;
  }
}