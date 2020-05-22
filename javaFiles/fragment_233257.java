public static final int FLAG_1 = 1<<0; // 0x01
public static final int FLAG_2 = 1<<1; // 0x02
public static final int FLAG_3 = 1<<2; // 0x04
public static final int FLAG_4 = 1<<3; // 0x08

public void myFlagsFunction( int flags ) {
  if ( 0 != ( flags & FLAG_1 ) ) {
    // do stuff
  }
  if ( 0 != ( flags & FLAG_2 ) ) {
    // do stuff
  }
}