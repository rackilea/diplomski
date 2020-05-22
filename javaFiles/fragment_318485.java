// delegation implementation details
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;

// notNull property delegate from stdlib
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;


class JavaClass {
    private final ReadWriteProperty<Object, String> x_delegate = Delegates.INSTANCE.notNull();
    private final static KProperty1 x_property = Reflection.mutableProperty1(
            new MutablePropertyReference1Impl(
                JvmClassMappingKt.getKotlinClass(JavaClass.class), "x", "<no_signature>"));

    public String getX() {
        return x_delegate.getValue(this, x_property);
    }

    public void setX(String value) {
        x_delegate.setValue(this, x_property, value);
    }
}

class Usage {
    public static void main(String[] args) {
        JavaClass instance = new JavaClass();
        instance.setX("new value");
        System.out.println(instance.getX());
    }
}