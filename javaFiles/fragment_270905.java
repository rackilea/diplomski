------------------      ------------------ 
    | Foo.class vtable |    | Bar.class vtable |
    |------------------|    |------------------|
    | clone            |    | clone            | \
    | equals           |    | equals           | | java.lang.Object
    | hashCode         |    | hashCode         | / virtual methods
    | ...              |    | ...              |
    | foo              |    | foo              | } Foo virtual methods
     ------------------     | bar              | } Bar virtual methods
                             ------------------