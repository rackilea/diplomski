@Target(AnnotationTarget.FIELD)
annotation class ExcludeOnDeserialization

class GsonExclusionStrategy : ExclusionStrategy {

    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
        return clazz?.getAnnotation(ExcludeOnDeserialization::class.java) != null
    }

    override fun shouldSkipField(f: FieldAttributes?): Boolean {
        return f?.getAnnotation(ExcludeOnDeserialization::class.java) != null
    }
}