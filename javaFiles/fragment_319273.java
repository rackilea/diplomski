@Query("select b from Bob b join b.toms t where t in (?1) group by b having count(t) >= ?2")
Iterable<Bob> findIfSubsetOfTomsExists(List<Tom> toms, int tomsCount);

default Iterable<Bob> getIfSubsetOfTomsExists(List<Tom> toms) {
    return findIfSubsetOfTomsExists(toms, toms.size());
}