package x;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class HelloBean
{
  public String sayHello( String name_ )
  {
    return "Hello " + name_ + "!";
  }
}