public interface DTOTransformerFactory {
    DTOTransformer<?, Item> getTransformer(Item item);
               // ^-------^ Here
}

public class DTOTransformerFactoryImpl implements DTOTransformerFactory {
    @Override
    public DTOTransformer<?, Item> getTransformer(Item item) {
                      // ^-------^ Here
        if (item instanceof RegularItemDTO) {
            return new RegularDTOTransformer<>();
                                         // ^^ Here, assuming RegularDTOTransformer is similarly parametrized.
        } else if (item instanceof SpecialItemDTO) {
            return new SpecialDTOTransformer<>();
                                         // ^^ Here.
        } else {
            throw new IllegalArgumentException("No transformer for type:     " + item.getClass());
        }
    }
}