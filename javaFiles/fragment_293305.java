@Id
@ManyToOne
@JoinColumn(name = "eintrag_id", referencedColumnName = "id")
public DkSystemtherapieEntity getDkSystemtherapieByEintragId() {
    return dkSystemtherapieByEintragId;
}