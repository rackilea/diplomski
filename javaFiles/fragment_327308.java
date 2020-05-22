class DataObject{

        @Expose @Serialize("a")
        DataA A;


        @Expose @Serialize("b")
        DataB B;

        @Expose @Serialize("not-required-a")
        JsonElement NotRequired;

        ...

 }