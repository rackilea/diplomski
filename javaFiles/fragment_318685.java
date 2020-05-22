@XmlRootElement(name = "OwnerReference")
@XmlType(propOrder = { "primaryValue", "alternativeSpelling"})
@Getter @Setter
public class AgencyOrUnit {
    private LocaleString PrimaryValue;
    private LocaleString AlternativeSpelling;
}