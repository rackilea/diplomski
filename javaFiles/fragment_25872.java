Double d1 = 1.0;
Double d2 = Double.POSITIVE_INFINITY;

int hash1 = d1.hashCode();
int hash2 = d2.hashCode();

// These both print -1092616192
// This was me using the wrong hash combinator *and*
// the wrong tuples... but it's interesting
System.out.println(hash1 * 17 + hash2);
System.out.println(hash2 * 17 + hash1);

// These both print -33554432
System.out.println(hash1 * 31 + hash1);
System.out.println(hash2 * 31 + hash2);