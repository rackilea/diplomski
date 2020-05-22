@Embeddable
public class Quantity{

   public enum Unit {FEET,METERS,INCHES,MM}

   @Enumerated( value = EnumType.STRING)
   private Unit unit;

   private Number amount;

   public Quantity() {

   }
}


@Entity
Public Class PurchaseOrder
{
    @Embedded
    @AttributeOverrides({
      @AttributeOverride(name="unit", column=@Column(name="UNIT")),
      @AttributeOverride(name="amount", column=@Column(name="AMOUNT"))
    })
    private Quantity quantity;
    ....

}