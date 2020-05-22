public class OtherBrands {

    @Override
    public boolean equals (Object other)
    {
        if (!(other instanceof OtherBrands))
            return false;
        OtherBrands ob = (OtherBrands) other;
        // add some checks here to handle any of the properties being null
        return otherbrandsname.equals(ob.otherbrandsname) &&
               dealerBrandQty.equals(ob.dealerBrandQty);
    }

    @Override
    public int hashCode ()
    {
        return Arrays.hashCode(new String[]{dealerBrandQty,otherbrandsname});
    }
}