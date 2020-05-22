@Entity
@Table(name = "companies")
public class Company {
   //..
   @OneToMany(mappedBy = "relatedCompany", cascade = CascadeType.ALL)
   private List<CompanyRelation> companyRelations = new ArrayList<>();
   //..
}

@Entity
@Table(name = "company_relations")
public class CompanyRelation {

//..

   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company relatedCompany;

//..

}