@Entity
@Table(name = "account_table")
public class AccountLink {

    @Column(name = "id")
    public Long id;

    @EmbeddedId
    private AccountLinkKey accountLinkKey;

    @Embeddable
    public class AccountLinkKey {
        @Column(name = "seg_account")
        private String segAccount;

        @Column(name = "sec_account")
        private String secAccount;
    }
}