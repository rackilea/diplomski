@XmlRootElement(name="flowPanel")
public class Image implements Serializable {

    public static class Label {
        @XmlAttribute()
        public String text;

        public Label(){}

        public Label(String text) {
            this.text = text;
        }   
    }

    @XmlElement(name="label")
    public Label name;
    @XmlElement(name="label")
    public Label description;    
}