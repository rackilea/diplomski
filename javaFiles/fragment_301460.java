int i = 1;
int j = 1;
Integer k = new Integer(1)
Integer l = new Integer(1)
Integer m = k;
Integer n = new Integer(k)

i == j -> true
k == l -> false
k == k -> true
k == l -> true
n == m -> false
n.intValue() == m.intValue() -> true (intValue returns a primitive type)