@JsonProperty("Name")
private String Name;

@JsonProperty("Price")
private BigDecimal Price;

@JsonProperty("Description")
private String Description;

@JsonProperty("categoryId")
@Column(name = "category_id", nullable = true)
private Long Category_id;