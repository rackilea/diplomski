public static void match(String name,String line)
{   

      String pattern = "("+name+".)([a-z][A-Z]\\w+)";
      // line = "private java.lang.String com.poc.Example.mName";
      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find( )) {
       /*  System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
        System.out.println("Found value: " + m.group(2) );*/
        list.add(m.group(1)+m.group(2));
      } 
}       public static void getFields(String className)
{
    //Field fields[]=a.getClass().getDeclaredFields();
    Field fields[];
    try {
        fields = Class.forName(className).getDeclaredFields();
        for(Field f:fields)
        {
            //System.out.println(f.toString());
            match(className,f.toString());
        }
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }catch (ExceptionInInitializerError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (MissingResourceException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}