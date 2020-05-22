@Basic
    @Column(name = "CARD_NUMBER", length = 18)
    String getCardNumber(){ ..}

    @Field(analyze = Analyze.NO, store = Store.YES, name="card_number")
    @SortableField
    @javax.persistence.Transient
    String getIndexedCardNumber() {
         return maskCardNumber( getCardNumber() );
    }