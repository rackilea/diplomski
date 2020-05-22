/**
* Do the same as "@routes.Assets.versioned" in Twirl.
* 
* @param url
*          relative path to the asset
* @return actual path to the asset
*/
public static CharSequence asset(final String url) {
  return controllers.routes.Assets.versioned(new controllers.Assets.Asset(url)).toString();
}