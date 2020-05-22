@Mapper
public interface ItemMapper {

    // Omitting other mappings for clarity
    @Mapping(source = "item", target = "locationDto", qualifiedByName = "locationDto")
    @Mapping(source = "item", target = "binType", qualifiedByName = "binType")
    @Mapping(source = "item", target = "lotSize", qualifiedByName = "lotSize")
    @Mapping(source = "item", target = "stockRails", qualifiedByName = "stockRails")
    ItemViewModel itemToDto(Item item);

    @Named("locationDto")
    default String locationToLocationDto(Item item) {
        //Omitting implementation
    }

    @Named("binType")
    default double locationToBinType(Item item) {
        //Omitting implementation
    }

    @Named("lotSize")
    default double itemToLotsize(Item item) {
        //Omitting implementation
    }

    @Named("stockRails")
    default double stockRails(Item item) {
        //Omitting implementation
    }
}