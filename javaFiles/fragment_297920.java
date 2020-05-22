@Context
private ResourceInfo resourceInfo;

@Override
public void filter(...) {
    Method method = resourceInfo.getResourceMethod();
    MyAnnotation anno = method.getAnnotation(MyAnnotation.class);
    if (anno != null) {
        String roles = anno.value();
    }
}