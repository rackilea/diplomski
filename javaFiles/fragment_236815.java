@Override
public boolean equals(Object o) {
  if (o == null) return false;
  if (itemName == null) return false;
  if (o instanceOf String) return itemName.equals(o);
  else if (o instanceOf GlobalData) return ((GlobalData) o).itemName.equals(this.itemName);
  else return false;
}