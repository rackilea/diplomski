@Documented
 @Retention(value=RUNTIME)
 @Target(value={CONSTRUCTOR,FIELD,LOCAL_VARIABLE,METHOD,PACKAGE,PARAMETER,TYPE})
public @interface Deprecated

A program element annotated @Deprecated is one that programmers are discouraged from using, typically because it is dangerous, or because a better alternative exists. Compilers warn when a deprecated program element is used or overridden in non-deprecated code.

Since:

1.5

See  The Java™ Language Specification:

9.6.3.6 @Deprecated