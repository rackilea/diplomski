$javap -pv Foo   // not Foo$
{
  public static int foo();
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: getstatic     #16                 // Field stat/Foo$.MODULE$:Lstat/Foo$;
         3: invokevirtual #18                 // Method stat/Foo$.foo:()I
         6: ireturn       
}