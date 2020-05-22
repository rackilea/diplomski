import java.util.*;

class CheckChanges {

  private static boolean isDifferent(Properties p1, Properties p2) {
    Set<Map.Entry<Object, Object>> p1EntrySet = p1.entrySet();
    Set<Map.Entry<Object, Object>> p2EntrySet = p2.entrySet();

    // Check that the key/value pairs are the same in the entry sets
    // obtained from the two Properties.
    // If there is an difference, return true.
    for (Map.Entry<Object, Object> e : p1EntrySet) {
      if (!p2EntrySet.contains(e))
        return true;
    }
    for (Map.Entry<Object, Object> e : p2EntrySet) {
      if (!p1EntrySet.contains(e))
        return true;
    }

    return false;
  }

  public static void main(String[] s)
  {
    // System properties prior to modification.
    Properties p = (Properties)System.getProperties().clone();
    // Modification of system properties.
    System.setProperty("dummy.property", "42");
    // See if there was modification. The output is "false"
    System.out.println(isDifferent(p, System.getProperties()));
  }
}