public class Object {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "object_translation",
                 foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_object_translation_object"),
                 joinColumns = @JoinColumn(name = "object_id"))
    @MapKeyColumn(name = "language", nullable = false)
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "translation", nullable = false)
    private Map<Language, String> translations;
}