@ManyToOne(fetch = FetchType.LAZY)
@JoinColumns({
      @JoinColumn(name = "id_parName", referencedColumnName="parName", nullable = false),
      @JoinColumn(name = "id_description", referencedColumnName="description", nullable = false),
      @JoinColumn(name = "id_note", referencedColumnName="note", nullable = false)
    })
public DefSelfLearning getDefSelfLearning() {
    return this.defSelfLearning;
}