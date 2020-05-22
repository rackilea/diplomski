import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.ObjectMapper;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibilityChecker(mapper.getVisibilityChecker().withFieldVisibility(Visibility.ANY));
    System.out.println(mapper.writeValueAsString(new Placement()));
    // output: {"placementId":42,"type":"OK","placement":"left","fileData":{"name":"Fred"}}
    // transient fields with getters are not skipped by default
  }
}

class Placement implements Serializable
{
  private static final long serialVersionUID = 1L;

  private long placementId = 42;
  private String type = "OK";
  private String placement = "left";
  private transient CommonsMultipartFile fileData = new CommonsMultipartFile();

  public CommonsMultipartFile getFileData() {return fileData;}
}

class CommonsMultipartFile
{
  private String name = "Fred";
}