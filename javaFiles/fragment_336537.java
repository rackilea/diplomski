@Embeddable
@Getter @Setter @NoArgsConstructor // Lombok library
public class EmbeddableGeneric<T> {
    @Column 
    // other annotations
    T myField;

    ...
}