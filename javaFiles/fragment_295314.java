class A implements Cloneable {
    public Object clone() {
         try {
             return super.clone();
         } catch (CloneNotSupportedException e) {
             throw new RuntimeException("Impossible exception!", e);
         }
    }
}