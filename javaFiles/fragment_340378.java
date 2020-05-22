@OneToMany(fetch=FetchType.EAGER, mappedBy = "product", targetEntity = ProductPrice.class, cascade = {CascadeType.ALL}, orphanRemoval=true)
    @Fetch(FetchMode.SUBSELECT)    
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="ncStandardElements")
    private List<ProductPrice> productPrices = new ArrayList<ProductPrice>();

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "product", targetEntity = ProductPrice.class)
    @Fetch(FetchMode.SUBSELECT)    
    @MapKeyJoinColumn(name="CURRENCY_ID")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="ncStandardElements")
    private Map<Currency, ProductPrice> productPriceMap = new HashMap<Currency, ProductPrice>();