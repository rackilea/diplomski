import com.google.auto.value.AutoValue;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Customer")
@XmlType(propOrder = {"name", "age", "id"})
@AutoValue.CopyAnnotations
@AutoValue
public abstract class Customer {

    public static Builder builder() {
        return new AutoValue_Customer.Builder();
    }

    @XmlElement(name = "name")
    abstract String getName();

    @XmlElement(name = "age")
    abstract int getAge();

    @XmlAttribute(name = "id")
    abstract int getId();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setName(String name);

        public abstract Builder setAge(int age);

        public abstract Builder setId(int id);

        public abstract Customer build();
    }
}