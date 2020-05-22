public class Category implements Serializable {
    ...
    private Long translatableDescriptionId;

    @OneToMany
    @JoinColumn(name="id", referencedColumnName="TranslatableDescriptionId") 
    private Set<TranslatableText> translatableText;
    ...
}