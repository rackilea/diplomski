@Id
@GenericGenerator(name="seq_id", strategy="my.package.StringKeyGenerator")
@GeneratedValue(generator="seq_id")
@Column(name = "TABLE_PK", unique = true, nullable = false, length = 20)
public String getId() {
    return this.id;
}