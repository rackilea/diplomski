@SuppressWarnings("unchecked")
public <T extends Unit> T getSpecializedUnitType(Class<T> unitTypeClass, String uniqueID) {
    Unit potentialTroop = units.get(uniqueID);
    if(potentialTroop == null) return null;

    return potentialTroop.getClass().equals(unitTypeClass) ?
        (T) potentialTroop : null;
}