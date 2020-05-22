public class Portfolio implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "PORTFOLIO_OWNER", referencedColumnName = "USER_ID", foreignKey = @ForeignKey(name = "FK__USER__PORTFOLIO"), nullable = false)
    @JsonIgnore
    private User portfolioOwner;

    @ManyToOne()
    @JoinColumn(name = "ACCOUNT_CAPTAIN", referencedColumnName = "USER_ID", foreignKey = @ForeignKey(name = "FK__USER__PORTFOLIO2"))
    private User accountCaptain;

}