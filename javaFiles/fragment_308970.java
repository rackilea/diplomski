// ModifyStringClass.groovy (a Groovy class)
class ModifyStringClass {
    public static messWithMetaClasses(String t) {
        java.lang.String.metaClass.substring = { int n -> "!" }
        println(t.substring(1))
    }
}