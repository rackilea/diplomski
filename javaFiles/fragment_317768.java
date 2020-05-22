import java.lang.reflect.*

val Type.rawtype: Class<*>
    get() = when (this) {
        is Class<*> -> this
        is ParameterizedType -> rawType as Class<*>
        is GenericArrayType -> genericComponentType.rawtype.asArrayType()
        is TypeVariable<*> ->
            this.bounds[0]?.rawtype ?: Any::class.java // <--- A bug of smart cast here, forcing the use of "this."
        is WildcardType -> lowerBounds[0].rawtype
        else -> throw AssertionError("Unexpected type of Type: " + javaClass)
    }

fun Class<*>.asArrayType() = java.lang.reflect.Array.newInstance(this, 0).javaClass