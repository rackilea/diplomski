Map.Entry<?, ?> oldValue = null;
for(Map.Entry<?, ?> newValue : values) {
   if (oldValue != null) {
      doSomethingWithBoth(oldValue, newValue);
   }
   oldValue = newValue;
}