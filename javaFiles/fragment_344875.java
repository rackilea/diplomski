@IdClass(PropertyId.class)
public class Property {

    private Integer referenceId;
    private Integer propertyId;
    private Integer indexValue;

    /**
      * You can use some repository instead
      *
      * setUp by using Either constructor Or setter injection
      */
    private Session session;

    public Property() {}
    public Property(Session session) {
        this.session = session;
    }

    @Id 
    public Integer getIndexValue() {
        if(indexValue != null)
            return indexValue;

        return (Integer)

            session.createQuery("select count(*) from Property p where p.propertyId.rederenceId = :referenceId and p.propertyId.propertyId = :propertyId")
                   .setParameter("referenceId", referenceId)
                   .setParameter("propertyId", propertyId)
                   .iterate()
                   .next();
    }

}