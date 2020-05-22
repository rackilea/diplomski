public class CustomScopeMetadataResolver extends Jsr330ScopeMetadataResolver {

  public Jsr330SpringScopeMetadataResolver() {
    registerScope(Request.class.getName(), WebApplicationContext.SCOPE_REQUEST);
  }

}