obj1.alpha = (refAlpha + 0.25f) % 1f
obj2.alpha = (refAlpha + 0.75f) % 1f

public static void main(String[] args) {
  System.out.println(1.25f % 1f); // --> 0.25
}