class Blah {

    val type : String? = null

    @ExcludeOnDeserialization // <- add this
    val myObject : Foo? = null
}