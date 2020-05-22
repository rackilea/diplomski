val a = Proxy.newProxyInstance(
        SomeInterface::class.java.classLoader,
        arrayOf(SomeInterface::class.java)) { proxy, method, args ->
    println("Before; args: " + args?.contentToString())
    val ret = method!!.invoke(obj, *(args ?: arrayOfNulls<Any>(0)))
    println("After; result: $ret")
    ret
} as SomeInterface

println(a.f(1, 2))