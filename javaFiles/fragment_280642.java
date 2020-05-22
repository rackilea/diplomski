final class Person {

    final String name = null;

    final int id = Integer.valueOf(0); // final primitive fields are inlined by javac

    @NotNull
    final Integer roll = null;

    @SerializedName("c")
    final Location location = null;

}