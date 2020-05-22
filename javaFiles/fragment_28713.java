// <? extends Event> in Java ==> <out Event> in Kotlin.
val myList: MutableList<Class<out Event>>

val param: Class<*> = methodThatHasSomeEventAsParam.parameterTypes[0]

if (Event::class.java.isAssignableFrom(param)) {
    param as Class<out Event>
    myList.add(param)
}