@Reference(multiple = true, dynamic = true)
public void setFoo(Foo foo, Map<String,Object> serviceProps) {
    if ("value".equals(serviceProps.get("canHandle"))) {
        // ...
    }
}