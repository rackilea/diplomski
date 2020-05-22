public class NamesSorter implements Comparator<EntityBean>{
    @Override
    public int compare (EntityBean a1, EntityBean a2) {
       String name1 = a1.getName();
       String name2 = a2.getName();
       // let's try trimming them..
       name1 = name1.trim();
       name2 = name2.trim();
       int comp = name1. compareToIgnoreCase( name2);
       log.debug("  name CI comparison: "+name1+", "+name2+"="+comp);
       // System.out.println("  name CI comparison: "+name1+", "+name2+"="+comp);
       return comp;
    }
}