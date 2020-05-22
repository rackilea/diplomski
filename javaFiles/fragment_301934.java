@Entity 
pubic class HistoricalServiceCall extends ServiceCall 
{
   @Id 
   private String id; 

}


@Embeddable 
public class ServiceCall {

   @OneToMany(fetch=FetchType.LAZY)
   @JoinColumn(name="join_column_defined_on_customer_table")
   List<HistoricalServiceCall> getServiceCallHistory(); 
}