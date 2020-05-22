package x;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CommandClient implements Serializable
{
  private String name;

  @EJB
  private CommandMgr commandMgr;

  public String getName()
  {
    return name;
  }

  public void setName( String name_ )
  {
    name = name_;
  }

  public void updateMessage( AjaxBehaviorEvent event_ )
  {
    Command cmd = createHelloCommand();
    FacesMessage msg = new FacesMessage( (String) commandMgr.send( cmd ) );
    FacesContext.getCurrentInstance().addMessage( "name", msg );
  }

  protected Command createHelloCommand()
  {
    Command cmd = new Command( CommandType.HELLO.ordinal() );
    cmd.getParams().put( "name", name );
    return cmd;
  }

}