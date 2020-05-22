String line = br.readLine();
    while (line != null && !line.isEmpty()) {
        Foo foo = parser.parse(line);
        fooList.add(foo);
        if(fooList.size() == 100){
            dao.write(fooList);
            fooList = new ArrayList<Foo>();
        }

        line = br.readLine();
    }