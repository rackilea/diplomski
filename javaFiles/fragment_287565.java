@Aspect
public class XyzAspect {

    @DeclareAnnotation("x.y.z.*")
    @Xyz class XyzClass {}

    @DeclareAnnotation("x.y.z.MyClass.*(..)")
    @Xyz void xyzMethod() {}
}