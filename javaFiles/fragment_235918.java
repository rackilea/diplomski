public class CompanyLocation {
   @DatabaseField(foreign = true)
   Company company;
   @DatabaseField(foreign = true)
   Location location;
}