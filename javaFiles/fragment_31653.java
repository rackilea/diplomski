public final class ManJSONAdapter {
  private final Man man;
  public ManJSONAdapter(Man man){
    this.man = man;
  }
  public String toJSON(){
    String result="{";
    if (man != null) {
      result += "name:";
      if (man.name == null){
        result += "undefined"
      } else {
        result += "'" + StringEscapeUtils.ESCAPE_ECMASCRIPT.translate(man.name) +"'";
      }
      result += ",wife:";
      if (man.wife == null) {
         result += "undefined";
      } else {
         ...
      }
    }
    result += "}";
    return result;
  }
}