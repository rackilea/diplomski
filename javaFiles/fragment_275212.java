@Entity
@Table(name = "tbl_country")
public class Country {
  private Integer countryId;

   @Id
   @Column(name="country_id")
   public String getCountryId(){
      return countryId;
   }  
}