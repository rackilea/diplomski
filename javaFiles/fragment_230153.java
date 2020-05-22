package x;

import javax.ejb.Remote;

@Remote
public interface CommandMgr
{
  public Object send( Command command_ );
}