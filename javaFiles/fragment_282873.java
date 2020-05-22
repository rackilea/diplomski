private static final Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .registerTypeAdapterFactory(getPostConstructTypeAdapterFactory())
        .create();

public static void main(final String... args) {
    final List<String> members = ImmutableList.of("Foo", "Bar", "Baz");
    final Club beforeClub = new Club(members);
    final List<String> beforeMembers = beforeClub.members;
    final int beforeSize = beforeClub.size;
    final String clubJson = gson.toJson(beforeClub);
    System.out.println(clubJson);
    final Club afterClub = gson.fromJson(clubJson, Club.class);
    final List<String> afterMembers = afterClub.members;
    final int afterSize = afterClub.size;
    if ( !beforeMembers.equals(afterMembers) ) {
        throw new AssertionError("`members` values do not match");
    }
    if ( beforeSize != afterSize ) {
        throw new AssertionError("`size` values do not match");
    }
    System.out.println("SUCCESS");
}