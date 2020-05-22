@Setter
@AllArgsConstructor
public class LocaleString {

    private String lang;
    private String value;

    @XmlAttribute
    public String getLang() {
        return lang;
    }

    @XmlValue
    public String getValue() {
        return value;
    }
}