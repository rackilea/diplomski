@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Audited
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "idHito", "tipoHito"})
@JsonIgnoreProperties({"idHitoAux", "hibernateLazyInitializer", "handler"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true, property = "tipoHito")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "hito_obra", value = HitoObra.class),
        @JsonSubTypes.Type(name = "hito_proyecto", value = HitoProyecto.class)
})<