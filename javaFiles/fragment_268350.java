long t1 = getFooInMillis();
long t2 = getBarInSeconds();

TypeSafe.<Long>areEqual(t1, t2);    // OK, just as we've seen earlier

TypeSafe.<@m Long>areEqual(t1, t2); // Error: incompatible types in argument
//                         ^^  ^^
// found   : @UnknownUnits long
// required: @m Long

@m long t1m = getFooInMillis();
@s long t2s = getBarInSeconds();
@m long t2m = getFooInMillis();

TypeSafe.<Long>areEqual(t1m, t2s);    // OK

TypeSafe.<@m Long>areEqual(t1m, t2s); // Error: incompatible types in argument
//                              ^^^
// found   : @s long
// required: @m Long

TypeSafe.<@m Long>areEqual(t1m, t2m); // OK