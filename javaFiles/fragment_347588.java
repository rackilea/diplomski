publi class Price{

  protected List<PricePointDetails> pricePointDetails;
  protected float shippingFee;
  protected PriceTypes priceType;
  protected priceTypeId;
  protected boolean onSale;

}//class closing

public class PricePointDetails{

 protected PriceTypes priceType;
 protected float value;
 protected LabelTypes labelType;

}//class closing


public enumeration PriceTypes{

 sale,regular,markdown;

}//enumeration closing

public enumeration LabelTypes{

 Orig,Now;

}//enumeration closing