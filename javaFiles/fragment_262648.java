Iterator<String> it = getarray.iterator();
while (it.hasNext()) {
      String myValue = it.next();
      if (myValue.trim().isEmpty()) {
            it.remove();
      } else {
            System.out.println("a: " + myValue);
      }
}