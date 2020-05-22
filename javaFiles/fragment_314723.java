public enum Equipment {

  HELMET(ARMOR),
  CHESTPIECE(ARMOR),
  BOOTS(ARMOR, CLOTHING),
  SWORD(WEAPON),
  MACE(WEAPON),
  HAMMER(WEAPON, TOOL),
  SHIELD(ARMOR),
  BOW(WEAPON),
  CROSSBOW(WEAPON),
  STAFF(WEAPON);

  private final Set<EquipmentType> types;

  Equipment(EquipmentType... eqTypes) {
    this.types = Arrays.stream(eqTypes)
                       .collect(Collectors.toSet());
  }

  // common filtering method
  private static List<Equipment> filterByType(EquipmentType type) {
    return Arrays.stream(values())
        .filter(eq -> eq.types.contains(type))
        .collect(Collectors.toList());
  }

  // dedicated methods for each group of items
  public static List<Equipment> getWeapons() {
    return filterByType(WEAPON);
  }

  public static List<Equipment> getArmor() {
    return filterByType(ARMOR);
  }

}