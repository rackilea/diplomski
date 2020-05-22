@Before("isRestController()")
public void handlePost(JoinPoint point) {
    MethodSignature signature = (MethodSignature) point.getSignature();
    Method method = signature.getMethod();

    // controller method annotations of type @RequestMapping
    RequestMapping[] reqMappingAnnotations = method
            .getAnnotationsByType(org.springframework.web.bind.annotation.RequestMapping.class);
    for (RequestMapping annotation : reqMappingAnnotations) {
        System.out.println(annotation.toString());
        for (RequestMethod reqMethod : annotation.method()) {
            System.out.println(reqMethod.name());
        }
    }

    // for specific handler methods ( @GetMapping , @PostMapping)
    Annotation[] annos = method.getDeclaredAnnotations();
    for (Annotation anno : annos) {
        if (anno.annotationType()
                .isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class)) {
            reqMappingAnnotations = anno.annotationType()
                    .getAnnotationsByType(org.springframework.web.bind.annotation.RequestMapping.class);
            for (RequestMapping annotation : reqMappingAnnotations) {
                System.out.println(annotation.toString());
                for (RequestMethod reqMethod : annotation.method()) {
                    System.out.println(reqMethod.name());
                }
            }
        }
    }
}