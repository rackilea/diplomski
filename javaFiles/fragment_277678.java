import java.io.Serializable;

@SuppressWarnings("serial")
public class DetailDto implements Serializable {
    String category1;
    Integer category2;
    Integer price;

    transient Integer totalPrice;

    public DetailDto() {
    }



    public DetailDto(String category1, Integer category2, Integer price, Integer totalPrice) {
        super();
        this.category1 = category1;
        this.category2 = category2;
        this.price = price;
        this.totalPrice = totalPrice;
    }



    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public Integer getCategory2() {
        return category2;
    }

    public void setCategory2(Integer category2) {
        this.category2 = category2;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    Key key() {
        return new Key(category1, category2, price);
    }

}
class Key {
    String category1;
    Integer category2;
    Integer price;

    public Key(String category1, Integer category2, Integer price) {
        super();
        this.category1 = category1;
        this.category2 = category2;
        this.price = price;
    }
    public String getCategory1() {
        return category1;
    }
    public Integer getCategory2() {
        return category2;
    }
    public Integer getPrice() {
        return price;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category1 == null) ? 0 : category1.hashCode());
        result = prime * result + ((category2 == null) ? 0 : category2.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Key other = (Key) obj;
        if (category1 == null) {
            if (other.category1 != null)
                return false;
        } else if (!category1.equals(other.category1))
            return false;
        if (category2 == null) {
            if (other.category2 != null)
                return false;
        } else if (!category2.equals(other.category2))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }
}