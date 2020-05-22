scala> import scala.reflect.runtime.{universe => ru}
scala> val m = ru.runtimeMirror(getClass.getClassLoader)

scala> val d = classOf[C$D]
d: Class[C$D] = class C$D

scala> m.runtimeClass(m.classSymbol(d).companionSymbol.asModule.moduleClass.asClass)
res16: Class[_] = class C$D$