// the efficient, but Java-only way outlined at the beginning
service MyCoolJavaService {
   binary Foo( 1: binary javaBytes)
}

// miror-model solution

struct EntityOne { ... whatever you need ... }
struct OtherEntity { ... whatever you need ... }
struct ThirdEntity { ... whatever you need ... }

service MyCoolModelService {
   EntityOne Foo( 1: ThirdEntity foo, 2: OtherEntity bar)
}