@Entity
@Table(name = "wallet_info")
public class WalletInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "currency")
    private String currency;

    // getters and setters 


   // constructors 

public WalletInfo(@NotNull String name, @NotNull String address, @NotNull String currency) {
        this.name = name;
        this.address = address;
        this.currency = currency;
    }

    public WalletInfo(@NotNull String name, @NotNull String address) {
        this.name = name;
        this.address = address;
    }

    public WalletInfo() {
    }
}