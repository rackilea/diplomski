package org.foo.bar;

public class MyClass {

    @MyAnn("annotated-field-1")
    private String field1;
    private String field2;

    @MyAnn("annotated-method-1")
    public String getValue1() {
        String value = null;
        try {
            MyAnn ann = getClass().getDeclaredMethod("getValue1").getAnnotation(MyAnn.class);
            if(ann != null) {
                value = ann.value();
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    public String getValue2() {
        String value = null;
        try {
            MyAnn ann = getClass().getDeclaredMethod("getValue2").getAnnotation(MyAnn.class);
            if(ann != null) {
                value = ann.value();
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    @Override
    public String toString() {
        String field1 = null;
        try {
            MyAnn ann = getClass().getDeclaredField("field1").getAnnotation(MyAnn.class);
            if(ann != null) {
                field1 = ann.value();
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        String field2 = null;
        try {
            MyAnn ann = getClass().getDeclaredField("field2").getAnnotation(MyAnn.class);
            if(ann != null) {
                field2 = ann.value();
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("MyClass");
        sb.append("{field1='").append(field1).append('\'');
        sb.append(", field2='").append(field2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}