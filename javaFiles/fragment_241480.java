@Entity
@Table(name = Settings.TABLE_NAME)
@AttributeOverride(name="id", column=@Column(name="SETTINGSID"))
public class Settings extends AbstractPersistable<Long> {
public static final String TABLE_NAME = "SETTINGS";


@Column(name = "CUSTOMERID")
private String customerID;

@Column(name = "MERCHANTID")
private String merchantID;
...