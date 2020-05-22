...
btnSelected.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        EquipUnequip(w.WeaponID(), (ImageButton)v);
    }
});
...

private void EquipUnequip(int WeaponId, ImageButton btnSelected) {
    if(Game.Weapons.get(WeaponId).CharacterID() == ChrSelected) {
        btnSelected.setImageResource(R.drawable.eqip_but_idle);
    } else {
        btnSelected.setImageResource(R.drawable.eqip_but_press);
    }
}