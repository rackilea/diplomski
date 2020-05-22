@Mapper
public abstract class ProductMapper{

    @Mapping( target = "amount", source = "object.price" ); 
    public abstract Product toProduct(ProductDto dto, @Context Integer decimals);

    public Float createPrice(Integer price, @Context Integer decimals) {
       // do some Float stuff here
    }

}