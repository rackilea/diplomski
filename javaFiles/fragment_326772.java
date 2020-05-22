@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "request_type", discriminatorType = DiscriminatorType.STRING)
public abstract class CashTransferCurrencyAmount {
    // id, version and so on

    @Column(length = 3)
    private String currencyCode;

    @Basic
    private BigDecimal amount;

    @ManyToOne
    private CashTransfer cashTransfer;
}

@Entity
@DiscriminatorValue("REQUIRED")
public class CashTransferCurrencyAmountRequired extends CashTransferCurrencyAmount {
    // required anount specific stuff here
}

@Entity
@DiscriminatorValue("ACTUAL")
public class CashTransferCurrencyAmountActual extends CashTransferCurrencyAmount {
    // actual anount specific stuff here
}

@Entity
public class CashTransfer {
    // id, version and so on

    @OneToMany(mappedBy="cashTransfer")
    private Set requiredCurrencyAmountSet = new HashSet();

//Stackoverflow deleting my generic sets! But it's exactly the same as in your code...

    @OneToMany(mappedBy="cashTransfer")
    private Set actualCurrencyAmountSet = new HashSet();
}