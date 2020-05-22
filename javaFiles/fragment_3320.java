import javafx.beans.NamedArg;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

import com.sun.javafx.property.PropertyReference;
import com.sun.javafx.scene.control.Logging;

// Original code from PropertyValueFactory
// Replacing ReadOnlyObjectWrapper with new ReadableWritableObservableValue
public class WritablePropertyValueFactory<S, T> implements Callback<CellDataFeatures<S, T>, ObservableValue<T>>
{
    private final String property;

    private Class<?> columnClass;
    private String previousProperty;
    private PropertyReference<T> propertyRef;

    public WritablePropertyValueFactory(@NamedArg("property") String property)
    {
        this.property = property;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservableValue<T> call(CellDataFeatures<S, T> param)
    {
        return getCellDataReflectively((T) param.getValue());
    }

    public final String getProperty()
    {
        return this.property;
    }

    private ObservableValue<T> getCellDataReflectively(T rowData)
    {
        if (getProperty() == null || getProperty().isEmpty() || rowData == null)
            return null;
        try
        {
            if (this.columnClass == null || this.previousProperty == null ||
                    !this.columnClass.equals(rowData.getClass()) ||
                    !this.previousProperty.equals(getProperty()))
            {
                this.columnClass = rowData.getClass();
                this.previousProperty = getProperty();
                this.propertyRef = new PropertyReference<T>(rowData.getClass(), getProperty());
            }
            if (this.propertyRef.hasProperty())
            {
                return this.propertyRef.getProperty(rowData);
            }
            else
            {
                // Create ReadableWritableObservableValue instead of ReadOnlyObjectWrapper
                return new ReadableWritableObservableValue<T>(
                        () -> this.propertyRef.get(rowData),
                        (value) -> this.propertyRef.set(rowData, value));
            }
        }
        catch (IllegalStateException e)
        {
            final PlatformLogger logger = Logging.getControlsLogger();
            if (logger.isLoggable(Level.WARNING))
            {
                logger.finest("Can not retrieve property '" + getProperty() +
                        "' in PropertyValueFactory: " + this +
                        " with provided class type: " + rowData.getClass(), e);
            }
        }
        return null;
    }
}