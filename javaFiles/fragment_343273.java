9.6.4.6. @Deprecated

A program element annotated @Deprecated is one that programmers are discouraged from using, typically because it is dangerous, or because a better alternative exists. 

A Java compiler must produce a deprecation warning when a type, method, field, or constructor whose declaration is annotated with @Deprecated is used (overridden, invoked, or referenced by name) in a construct which is explicitly or implicitly declared, unless: 

- The use is within an entity that is itself annotated with the annotation @Deprecated; or 
- The use is within an entity that is annotated to suppress the warning with the annotation @SuppressWarnings("deprecation"); or 
- The use and declaration are both within the same outermost class.     

Use of the @Deprecated annotation on a local variable declaration or on a parameter declaration has no effect. 

The only implicitly declared construct that can cause a deprecation warning is a container annotation (§9.7.5). Namely, if T is a repeatable annotation type and TC is its containing annotation type, and TC is deprecated, then repeating the @T annotation will cause a deprecation warning. The warning is due to the implicit @TC container annotation. It is strongly discouraged to deprecate a containing annotation type without deprecating the corresponding repeatable annotation type.