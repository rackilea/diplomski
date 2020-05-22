package x;

import java.util.HashMap;
import java.util.Map;

public class Command
{
  private int type;
  private final Map<String,Object> params = new HashMap<>();

  public Command( int type_ ) { type = type_; }
  public int getType() { return type; }
  public Map<String,Object> getParams() { return params; }
  public Object getParamByKey( String key_ ) { return params.get( key_ ); }
}