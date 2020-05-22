@Aspect
public class CustomAnnotationAOP {


@Pointcut("@annotation(it.federicogatti.annotationexample.annotationexample.annotation.CustomAnnotation)")
 //define your method with logic to lookup application.properties