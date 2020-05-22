Foo<String> foo = new Foo<String>() {
        public void bar(String s, String t) {
            System.out.println(s);
            System.out.println(s);
        }
    };
    foo.bar(hi,bye);