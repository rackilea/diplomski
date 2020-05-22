public final class Utilities { 
  ... 
  public static <T> HashSet<T> create(int size) {  
    return new HashSet<T>(size);  
  } 
} 
public final class Test 
  public static void main(String[] args) { 
    HashSet<Integer> hi = Utilities.create(10); // T is inferred from LHS to be `Integer`
  } 
}