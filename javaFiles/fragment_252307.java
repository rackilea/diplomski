OptionalLong optMin = messages.stream().mapToLong(Message::getOffset).min();
if(!optMin.isPresent()) return;
long min = optMin.getAsLong();
BitSet bset = messages.stream()
    .mapToLong(Message::getOffset)
    .collect(BitSet::new, (bs,l) -> bs.set((int)(l-min)), BitSet::or);
for(int set=0, clear; set>=0; ) {
    clear = bset.nextClearBit(set);
    set = bset.nextSetBit(clear);
    if(set >= 0)
        LOG.error("Missing offset(s) found in messages: missing from {} to {}",
                  min+clear, min+set);
}