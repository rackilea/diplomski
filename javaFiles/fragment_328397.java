tmp = new Foo()

    [w] write to list at index 2

    [f] freeze at constructor exit

shared = tmp;   [a]  a normal write

// Another Thread

foo = shared;   [r0] a normal read

if(foo!=null) // [r0] sees [a], therefore mc(a, r0)

    map = foo.map;          [r1] reads a final field

    map.get("etc").get(2)   [r2]