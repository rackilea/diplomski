class MyObject {
Object field1;
Object field2;
int field3;
public int hashCode() { return field1.hashCode() + field2.hashCode() + field3; }
public boolean equals(Object o) {
    if (!(o instanceof MyObject)) return false;
    MyObject a = (MyObject)o;
    return field1.equals(a.field1) && field2.equals(a.field2) && field3 == a.field3; }