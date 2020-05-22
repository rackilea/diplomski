scala.this.Predef.println(
  scala.Int.box(Demo$MyInt.this.inc$extension(Demo.this.MyInt(42)))
);

scala.this.Predef.println(
  scala.Char.box(
    Demo$MyString.this.firstChar$extension(Demo.this.MyString("hello"))
  )
);

scala.this.Predef.println(
  scala.Char.box(
    Demo.this.MyNonValueClassString("hello").firstCharNonValueClass()
  )
);