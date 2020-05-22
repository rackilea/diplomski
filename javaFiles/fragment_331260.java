private void addWeaponToUI() {
    et_name_value.setText(weapon.getWeaponName());
    np_damage_number_of_die_value.setValue(weapon.getWeaponDamageNumberOfDie());
    SheetEnum.Ability ability = SheetEnum.Ability.getEnumValue(weapon.getWeaponAbilityBonusInt());
    tv_attack_bonus_value.setText(String.valueOf(sheet.getAbilityBonus(ability)));

    // REMOVE below lines!
    //s_damage_die_type_value.setSelection(weapon.getWeaponDamageDieTypeInt());
    //s_damage_type_value.setSelection(weapon.getWeaponDamageTypeInt());
    //s_ability_bonus_value.setSelection(weapon.getWeaponAbilityBonusInt());
}