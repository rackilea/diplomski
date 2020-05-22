public boolean isFull(Object[] array) {
   for (Object element : array) {
      if (element == null) return false;
   }
   return true;
}