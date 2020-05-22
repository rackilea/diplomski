@Data
@NoArgsConstructor
@Entity
@Table(name = "carriers")
public class Carrier {
    @Id private String carrierId;

    public Carrier(final String carrierId) {
        this.carrierId = carrierId;
    }
}