public class Key
{
int hashCode = 0;

@Override
public int hashCode() {
    return hashCode;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Key other = (Key) obj;
    return hashCode == other.hashCode;
}

public static void main(String[] args) throws Exception {
    HashMap<Key, Integer> data = new HashMap<Key, Integer>();
    Key k1 = new Key();
    data.put(k1, 1);

    k1.hashCode = 1;

    boolean bool1 = data.containsKey(k1);
    for (Key k2 : data.keySet()) {
        boolean bool2 = k1.equals(k2);
        boolean bool3 = k2.equals(k1);
        boolean bool4 = k1.hashCode() == k2.hashCode();

        System.out.println("bool1: " + bool1);
        System.out.println("bool2: " + bool2);
        System.out.println("bool3: " + bool3);
        System.out.println("bool4: " + bool4);

        break;
    }
}
}