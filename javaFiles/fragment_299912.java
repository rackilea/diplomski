@Entity
@Table(name = "Release")
public class Release implements Serializable
{
  //...
  public String getUserImageLink(){
    StringBuilder imageUrlBuilder = new StringBuilder(Release.servletContext.getContextPath())
        .append("/resources/images")
        .append(this.user);
    return imageUrlBuilder.toString();
  }
}