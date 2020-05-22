@RequestMapping(value = "/foo2", method = RequestMethod.GET)
public String fooMethod2() {
    try {
        Method m = YourClassController.class.getMethod("fooMethod2");
        String path = m.getAnnotation(RequestMapping.class).value()[0];
        System.out.println("foo2 path: " + path);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }

    return "bar";
}