@Documented
@Target(value=FIELD)
@Retention(value=RUNTIME)
public @interface InjectMocks
Mark a field on which injection should be performed.
Allows shorthand mock and spy injection.
Minimizes repetitive mock and spy injection.
Mockito will try to inject mocks only either by constructor injection, setter injection, or property injection in order and as described below. If any of the following strategy fail, then Mockito won't report failure; i.e. you will have to provide dependencies yourself.

Constructor injection; the biggest constructor is chosen, then arguments are resolved with mocks declared in the test only. If the object is successfully created with the constructor, then Mockito won't try the other strategies. Mockito has decided to no corrupt an object if it has a parametered constructor.
Note: If arguments can not be found, then null is passed. If non-mockable types are wanted, then constructor injection won't happen. In these cases, you will have to satisfy dependencies yourself.

Property setter injection; mocks will first be resolved by type (if a single type match injection will happen regardless of the name), then, if there is several property of the same type, by the match of the property name and the mock name.
Note 1: If you have properties with the same type (or same erasure), it's better to name all @Mock annotated fields with the matching properties, otherwise Mockito might get confused and injection won't happen.

Note 2: If @InjectMocks instance wasn't initialized before and have a no-arg constructor, then it will be initialized with this constructor.

Field injection; mocks will first be resolved by type (if a single type match injection will happen regardless of the name), then, if there is several property of the same type, by the match of the field name and the mock name.
Note 1: If you have fields with the same type (or same erasure), it's better to name all @Mock annotated fields with the matching fields, otherwise Mockito might get confused and injection won't happen.

Note 2: If @InjectMocks instance wasn't initialized before and have a no-arg constructor, then it will be initialized with this constructor.