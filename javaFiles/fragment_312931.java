private BiConsumer<MyObject, List<? extends MyOtherObject>> setter;
...

BiConsumer<MyObject, List<? extends MyOtherObject>> listWildCard = ...;
this.setter = listWildCard; // compiles

BiConsumer<MyObject, List<MyOtherObject>> listSpecificType = ...;
this.setter = listSpecificType ; // doesn't compile