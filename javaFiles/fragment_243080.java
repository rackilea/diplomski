import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.StringConverter;


public class BigDecimalBindingTest {

    public static void main(String[] args) {
        Temp temp = new Temp();
        temp.addPropertyChangeListener(evt -> 
                System.out.printf("temp changed from %s to %s %n", evt.getOldValue(), evt.getNewValue()));

        temp.setWeight(BigDecimal.ZERO);
        TempAdapter adapter = new TempAdapter(temp);
        adapter.weightProperty.addListener((obs, oldValue, newValue) -> 
            System.out.printf("adapter changed from %s to %s%n", oldValue, newValue));

        StringProperty text = new SimpleStringProperty();

        text.addListener((obs, oldValue, newValue) -> 
                System.out.printf("text changed from %s to %s%n", oldValue, newValue));

        text.bindBidirectional(adapter.getWeightProperty(), new StringConverter<BigDecimal>(){

            @Override
            public String toString(BigDecimal object) {
                return object.toString();
            }

            @Override
            public BigDecimal fromString(String string) {
                return new BigDecimal(string);
            }

        });



        System.out.println("Setting temp");
        temp.setWeight(new BigDecimal(2));

        System.out.println("Setting text");
        text.set("3.0");
    }

    public static class Temp{
        private BigDecimal weight;
        private final PropertyChangeSupport propertyChangeSupport;
        public Temp() {
             this.propertyChangeSupport = new PropertyChangeSupport(this);
        }
        public void addPropertyChangeListener(PropertyChangeListener listener) {
             propertyChangeSupport.addPropertyChangeListener(listener);
        }
        public BigDecimal getWeight() {
          return weight;
        }
        public void setWeight(BigDecimal weight) {
          BigDecimal pv = this.weight;
         this.weight = weight;
         propertyChangeSupport.firePropertyChange("weight", pv, weight);
        }
     }

    public static class TempAdapter {
        private ObjectProperty<BigDecimal> weightProperty;

        public TempAdapter(Temp temp) {
            try {
                weightProperty = new JavaBeanObjectPropertyBuilder<BigDecimal>()
                        .bean(temp).name("weight").build();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
                        null, ex);
            }
        }

        public ObjectProperty<BigDecimal> getWeightProperty() {
            return weightProperty;
        }

    }

}