public class GoogleMapLocation {
    List<Result> results;

    String status;
}

public class Result {
    @SerializedName("address_components")
    private List<AddressComponent> addressComponents;

    @SerializedName("formatted_address")
    private String formattedAddress;

    private Geometry geometry;

    @SerializedName("partial_match")
    private String partialMatch; // not sure of the type

    private List<String> types;
}

public class AddressComponents {
    @SerializedName("long_name")
    private String longName;

    @SerializedName("short_name")
    private String shortName;

    private List<String> types;
}

public class Geometry {
    LatLng location;

    Viewport viewport;

    Viewport bounds;

    @SerializedName("location_type")
    String locationType;
}

public class LatLng {
    @SerializedName("lat");
    private double latitude;

    @SerializedName("lng");
    private double longitude;
}

public class Viewport {
    private LatLng northeast;

    private LatLng southwest;
}