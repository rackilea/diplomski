Agent agent = null;
boolean isFemale = false;
for (int i = 0; i < 100; i++) {
        int id = i++;
        if(id > 50) {
            isFemale = true;
        }
        agent = new Agent(context, geography, i, isFemale);
        context.add(agent);
        //specifies where to add the agent
        Coordinate coord = new Coordinate(-79.6976, 43.4763);
        Point geom = fac.createPoint(coord);
        geography.move(agent, geom);
    }