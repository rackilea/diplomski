public static void main(String[] args) {
19.            Foo foo = new Foo(300);
20.            System.out.println(foo.getX() + "-"); // 300

21.            Foo fooBoo = fooBar(foo);   // foo is "unchanged" here
22.            System.out.println(foo.getX() + "-");  // printing foo --> 300
23.            System.out.println(fooBoo.getX() + "-"); // printing fooBoo --> 100

24.           foo = fooBar(fooBoo); // changing foo and setting it to 100
25.            System.out.println(foo.getX() + "-"); // So foo will be --> 100
26.            System.out.println(fooBoo.getX() + "-");// fooBoo is already -->100
27.        }