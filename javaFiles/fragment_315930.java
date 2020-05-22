public static final Function<Obj, String> FOO = new Function<Obj, String>() {
            public String apply(Obj input) {
                return input.foo;
            }
        };

List<String> fooList = Lists.transoform(targetList, Object.FOO)
or 
List<String> fooList = Collections2.transoform(targetList, Object.FOO)