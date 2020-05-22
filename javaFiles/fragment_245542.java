@Entity
@Table(name = "report")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "report_type_id", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Report<E extends Exception> {
    @Id @Column(name="id")
    private long id;

    @column(name="description")
    private String description;
   ...
   ...
}

@Entity(name = "CreditScoreReport")
@DiscriminatorValue("1") // the id corresponding to the credit score report
public class CreditScoreReport<E extends Exception> extends Report<E> {

   @Column(name = "specific_credit_score_report_1)
   private Integer specificCreditScoreReport1;

   public void doCreditScoreStuff(){
      ...
   }
}

@Entity(name = "DmvReport")
@DiscriminatorValue("2") // the id corresponding to the DMV report
public class DmvReport<E extends Exception> extends Report<E> {

   @Column(name = "specific_dmv_score_report_1)
   private Integer specificDmvScoreReport1;

   public void doDmvStuff(){
      ...
   }
}