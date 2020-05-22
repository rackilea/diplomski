public enum Week 
{
     SUNDAY(0),
     MONDAY(1)

     private static final Map<Integer,Week> lookup 
          = new HashMap<Integer,Week>();

     static {
          for(Week w : EnumSet.allOf(Week.class))
               lookup.put(w.getCode(), w);
     }

     private int code;

     private Week(int code) {
          this.code = code;
     }

     public int getCode() { return code; }

     public static Week get(int code) { 
          return lookup.get(code); 
     }
}