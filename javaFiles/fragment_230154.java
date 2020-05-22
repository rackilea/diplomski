package x;

import java.security.InvalidParameterException;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless( name = "commandMgr" )
public class CommandMgrImp implements CommandMgr
{

  @Inject
  private HelloBean helloBean;

  @Override
  public Object send( Command command_ )
  {
    if ( command_ != null )
      switch ( command_.getType() )
      {
        case 1:
          return helloBean.sayHello( (String) command_.getParamByKey( "name" ) );
        default:
          return null;
      }
    else
      throw new InvalidParameterException( "CommandMgrImp.send() : command_=null");
  }

}