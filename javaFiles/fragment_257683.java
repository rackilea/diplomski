public boolean checkUses(String weapon) {
  for (Scout scout : scouts)
    if (scout.getRangedUpgrade() == WeaponList.getRanged(weapon)
      return true;
  return false;
}