@Entity
public class Documents {
    @Id
    private Long id;

    @Lob
    private byte[] doc;

    // .... getters + setters 
}