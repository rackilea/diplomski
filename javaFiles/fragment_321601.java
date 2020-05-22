public void write(T t) {
   if (!verifyType(t)) explode();
   //...do write
}

public boolean verifyType(T t) {
   return valueType.isInstance(t);
}