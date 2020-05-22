HashMap<String, Foo> map = new HashMap<String, Foo>();
    for (Foo bar: this.FooList)
    {
        if (!map.containsKey(bar.getName()))
        {
            map.put(bar.getName(), bar);
        }
        else
        {
            Foo foo = map.get(bar.getName());
            if (foo != null)
                foo.doSomeThing();
            map.put(bar.getName(), null);
        }
    }