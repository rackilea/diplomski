@Maper
public interface AdressMapper {


    default Source toEntity(Base b) {
        if (b == null) {
            return null;
        } else if (b instanceOf A) {
            toEntity((A) b);
        } else if (b instanceOf B) {
            toEntity((A) b);
        } else if (b instanceOf C) {
            toEntity((C) b);
        } else {
            // Decide what to do
        }
    }

    @Mapping(target = "address", source = "emailAddress")
    Source toEntity(A a);

    @Mapping(target = "address", source = "devices")
    Source toEntity(B b);

    @Mapping(target = "address", source = "mobileNumbers")
    Source toEntity(C c);

    default Base toDomain(Source source) {
        if (source == null) {
            return null;
        } else if (condition to match to A) {
            return toDomainA(source);
        } else if (condition to match to B) {
            return toDomainB(source);
        } else if (condition to match to C) {
            return toDomainC(source);
        }
    }

    @Mapping(target = "emailAddress", source = "address")
    A toDomainA(Source source);

    @Mapping(target = "devices", source = "address")
    B toDomainB(Source source);

    @Mapping(target = "mobileNumbers", source = "address")
    C toDomainB(Source source);


    // This method is needed so MapStruct knows how to map from List<String> into String
    static <T> String listToString(List<T> list) {
        if (list == null) {
            return null;
        }

        return list.toString();
    }

    // This method is needed so MapStruct know hot to map from String into List<String>
    static List<String> fromListToString(String string) {
        if (string == null) {
            return null;
        }

        // Perform your own conversion
    }
}