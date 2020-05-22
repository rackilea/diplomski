LinkedHashMultimap<Date, Stat> stats = LinkedHashMultimap.create();

//Every minute
stats.putAll(new Date(), newStats);

//To get the first key inserted into the map
Date first = Iterables.getFirst(stats.keys(), null);
//Remove the first entry
stats.remove(first);

//To get the last key inserted into the map
Date last = Iterables.getLast(stats.keys(), null);
//Remove the last entry
stats.remove(last);

//Without using Iterables.
Set<Date> keys = stats.keys();
if (!keys.isEmpty()) {
    keys.iterator().next().remove();
}