class A implements Cloneable {
    public A clone() {
         try {
             return (A) super.clone();
         } catch (CloneNotSupportedException e) {
             throw new RuntimeException("Impossible exception!", e);
         }
    }
}