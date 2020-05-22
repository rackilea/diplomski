// a single House is constructed
House house = new House(); 
// omitted: add rooms to the house...

// create a first vacuum cleaner for the house. A reference to the house is given to this cleaner
VacuumCleaner vacuumCleaner = new VacuumCleaner(house);
System.out(vacuumCleaner.isRoomClean(2)); // prints false, because room 2 is full of dirt
vacuumCleaner.cleanRoom(2);
System.out(vacuumCleaner.isRoomClean(2)); // prints true, because the vacuum cleaner removed the dirt from room 2

// now let's create a second vacuum cleaner for the same house
VacuumCleaner vacuumCleaner2 = new VacuumCleaner(house);
System.out(vacuumCleaner2.isRoomClean(2)); // prints true, because room 2 has no dirt: it has previously been removed from the room by the first vacuum cleaner.