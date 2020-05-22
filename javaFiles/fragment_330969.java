class Schedule {
         private Change change;
         private Cost cost;
         private Location location;

        public Schedule(Location location, Cost cost, Change change) {
           this.change = change;
           this.cost = cost;
           this.location = location;
        }
}