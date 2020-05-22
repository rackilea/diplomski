private getEquipmentPredicate(CriteriaBuilder cb, Root<Truck> root) {
    EquipmentType type = findEquipmentType("not related to this answer");
    Expression<List<EquipmentType>> equipments = root.get(Truck_.equipmentTypes);
    Predicate p = cb.isMember(type, equipments);
    return p;
}