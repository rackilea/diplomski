Colllection<Foo> mc = new ArrayList<Foo>();

mc.add(new Foo());
mc.add(someFoo1=new Foo());
mc.add(new Foo());
mc.add(someFoo2=new Foo());

mc.remove(someFoo1);
mc.remove(someFoo2);