public class Variation_details
{
    private String[] image;

    private String quantity;

    private String price;

    private String specifications;

    private String variation_title;

    public String[] getImage ()
    {
        return image;
    }

    public void setImage (String[] image)
    {
        this.image = image;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getSpecifications ()
    {
        return specifications;
    }

    public void setSpecifications (String specifications)
    {
        this.specifications = specifications;
    }

    public String getVariation_title ()
    {
        return variation_title;
    }

    public void setVariation_title (String variation_title)
    {
        this.variation_title = variation_title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+", quantity = "+quantity+", price = "+price+", specifications = "+specifications+", variation_title = "+variation_title+"]";
    }
}