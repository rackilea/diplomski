List<EventA> list = ...;
List<Historical> h = (List<Historical>) list;
h.add(new EventB()); //type-safety of list is compromised
for (EventA evt : list) { // ClassCastException - there's an EventB in the lsit
   ...
}