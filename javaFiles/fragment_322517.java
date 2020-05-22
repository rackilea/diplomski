package org.foo.bar;

public aspect ToggleAnnotationAspect {

    declare @field : private String org.foo.bar.MyClass.field1 : -@MyAnn;
    declare @field : private String org.foo.bar.MyClass.field2 : @MyAnn("annotated-field-2");

    declare @method : public String org.foo.bar.MyClass.getValue2() : @MyAnn("annotated-method-2");

}