public class User {

    ...

    // see the first ligne of UserAddressAdapter#write
    // city => (out.value(value.getCity());)
    @SerializedName("city")
    @JsonAdapter(UserAddressAdapter.class)
    private final UserAddress userAddress;
    ...

}


public class UserAddressAdapter extends TypeAdapter<UserAddress> {

    @Override
    public void write(JsonWriter out, UserAddress value) throws IOException {
        out.value(value.getCity());
        out.name("country");
        out.value(value.getCountry());
        out.name("houseNumber");
        out.value(value.getHouseNumber());
        out.name("street");
        out.value(value.getStreet());
    }

    @Override
    public UserAddress read(JsonReader in) throws IOException {
        final int city = in.nextInt();
        UserAddress[] scopes = UserAddress.values();
        for (UserAddress scope : scopes) {
            if (scope.getCity() == city) {
                return scope;
            }
        }
        return null;
    }

}