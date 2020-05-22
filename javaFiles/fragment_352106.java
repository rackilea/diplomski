interface FrontEnd {
    public static FrontEnd get() {
        return (FrontEnd)Proxy.newProxyInstance(FrontEnd.class.getClassLoader(),
            new Class<?>[]{FrontEnd.class}, (proxy, method, args) -> {
                if(method.getDeclaringClass() == Object.class) {
                    switch(method.getName()) {
                        case "toString": return
                            FrontEnd.class.getName()+'@'+System.identityHashCode(proxy);
                        case "equals": return proxy == args[0];
                        case "hashCode": return System.identityHashCode(proxy);
                        default: throw new AssertionError();
                    }
                }
                SwagRef swagRef = method.getAnnotation(SwagRef.class);
                if(swagRef == null) throw new IncompatibleClassChangeError();
                MyParam[] p = Arrays.stream(method.getParameterAnnotations())
                    .map(pa -> Arrays.stream(pa)
                        .filter(a -> a.annotationType() == MyParam.class)
                        .findFirst().orElseThrow(
                            () -> new IllegalStateException("missing required @MyParam")))
                    .toArray(MyParam[]::new);
                Map<String,String> map = IntStream.range(0, args.length).boxed()
                    .filter(i -> p[i].required() || args[i] != null)
                    .collect(Collectors.toMap(i -> p[i].name(), i -> args[i].toString()));
                // do actual invocation logic here
                System.out.println(
                    "operation: "+swagRef.method()+' '+swagRef.url()+", "+map);
                return null;
        });
    }

    @SwagRef(method = POST, url = "/my/api/{pathParam1}")
    public Response callMyAPI(
        @MyParam(name = "pathParam1", required = true, in = PATH) String p1,
        @MyParam(name = "param2", required = false, in = QUERY) String p2);
}