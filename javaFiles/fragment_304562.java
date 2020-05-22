import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static javax.xml.bind.JAXB.marshal;

@XmlRootElement(name="Products")
public class ProdsList {

  @XmlElement(name="Product")
  private ArrayList<Product> prods;

  public ProdsList() {}

  public ProdsList(ArrayList<Product> value){
    prods = value;
  }

  public ArrayList<Product> getProd() {
    return prods;
  }

  public void setProducts(ArrayList<Product> prod) {
    this.prods = prod;
  }
}