public List<List<List<String>>> lista = new ArrayList<List<List<String>>>(){{
    for(int i=0;i<3;i++)
        add(new ArrayList<List<String>>(){{
            for(int i=0;i<4;i++)
                add(new ArrayList<>(5));
        }});
}};