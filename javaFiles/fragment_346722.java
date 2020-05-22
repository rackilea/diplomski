//Initialize at the start of your program
HashMap<int, Slot> SlotHash = new HashMap<int, Slot>();

//Code to retrieve slot and call Draw().
Slot select = SlotHash.get(slotNumber);
select.Draw();