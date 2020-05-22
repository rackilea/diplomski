Set<Name> result = new HashSet<>();
try { 
  for (;;) { 
    result.add((Name)objectInputStream.readObject());
  }
} catch (EOFException e) {
  // End of stream
} 
return result;