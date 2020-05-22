LinkedList<Entity> upcomingStatusEntities = new LinkedList<Entity>();
LinkedList<Entity> pastStatusEntities = new LinkedList<Entity>();

for(Entity p1:pq.asIterable()){
    Date dateofvisit1 =formatter.parse(p1.getProperty("DateOfVisit").toString());
    if (dateofvisit1.after(date)){
        upcomingStatusEntities.add(p1);
    }
    else{
        pastStatusEntities.add(p1);
    }
}