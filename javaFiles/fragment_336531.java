public class SearchStepsDefinitions {

   private Context context;
   private EJBContainer container;

   private List<User> userList = new ArrayList<>();

   private UserService userService;

   @cucumber.api.java.Before
   public void setup() {
       ejbContainer = EJBContainer.createEJBContainer();
       context = ejbContainer.getContext();

       userService = (UserService) context.lookup("java:global/classes/UserService");
   }

   @cucumber.api.java.After
   public void teardown() {
       ejbContainer.close();
   }

   @Given(value = ".+user with the name '(.+)'$")
   public void a_user_with_the_name(final String userName) {
       userService.add(userName);
   }

   @When(value = "^the customer searches for a user with the name '(.+)'$")
   public void the_customer_searches_for_a_user_with_the_name(final String name) {
       userList = userService.findByName(name); 
   }

   @Then(value = "(\\d+) users should have been found$")
   public void users_should_have_been_found(final int userCount) {
       assertThat(userList.size(), equalTo(userCount));
   }

   @Then(value = "User (\\d+) should have a name of '(.+)'$")
   public void should_have_a_name_of(final int position, final String name) {
       assertThat(userList.get(position - 1).getName(), equalTo(name)); 
   }

}