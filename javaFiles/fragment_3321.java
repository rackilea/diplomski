import java.util.function.Consumer;
import java.util.function.Supplier;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;

public class ReadableWritableObservableValue<T> implements ObservableValue<T>, WritableValue<T>
{
    protected final Supplier<T> getter;
    protected final Consumer<T> setter;

    public ReadableWritableObservableValue(Supplier<T> getter, Consumer<T> setter)
    {
        this.getter = getter;
        this.setter = setter;
    }

    @Override
    public void addListener(InvalidationListener listener)
    {
        // useless (no property to listen)
    }

    @Override
    public void removeListener(InvalidationListener listener)
    {
        // useless (no property to listen)
    }

    @Override
    public void addListener(ChangeListener<? super T> listener)
    {
        // useless (no property to listen)
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener)
    {
        // useless (no property to listen)
    }

    @Override
    public T getValue()
    {
        return this.getter.get();
    }

    @Override
    public void setValue(T value)
    {
        this.setter.accept(value);
    }
}