public void log(Level level,
                    String msg,
                    Object[] obj,
                    Throwable thrown)
{
   //StringBuilder buff = ...
   // some string manipulation with 'msg' and 'obj'
   // ...
   log(level, buff.toString(), thrown);
}