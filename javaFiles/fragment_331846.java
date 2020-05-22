private TreeMap<Integer, Integer> aboveNbr_increment_map;

private Integer getIncrementValueAboveNbr(int nbr) {

    Entry<Integer, Integer> entry = aboveNbr_increment_map.floorEntry(nbr);

    if(entry != null) {
        return nbr + entry.getValue();
    }

    return aboveNbr_increment_map.get(aboveNbr_increment_map.firstKey());
}