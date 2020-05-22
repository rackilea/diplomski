@Override
@Transactional
public boolean cancel(String extId) {
    Optional<TableA> maybeTableA = repository.findTableA(extId, DELETE_STATUS_SET);

    return maybeTableA.map(tableA -> {

        // update tableB
        TableB tableB = tableA.getTableB();
        tableB.setExtId(null);
        tableB.setTableA(null);
        tableBRepository.save(tableB);

        // and update tableA
        repository.delete(tableA);
        return true;
    }).orElse(false);
}