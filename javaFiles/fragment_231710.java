public boolean equals(Object obj) { 
  if (obj == null) return false;
  if (obj.getClass() != this.getClass()) return false;
  Phone t = (Phone ) obj; 
  return t.number.equals(this.number);
}