ArrayAdapter<CharSequence> damageDieTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.die_type, android.R.layout.simple_spinner_dropdown_item);
    s_damage_die_type_value.setAdapter(damageDieTypeAdapter);
    //Set selection before listener
    s_damage_die_type_value.setSelection(weapon.getWeaponDamageDieTypeInt());
    s_damage_die_type_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
            //Check selected position is not equal to current position to avoid an infinite loop
            if (position != weapon.getWeaponDamageDieTypeInt()) {
                String[] value = getContext().getResources().getStringArray(R.array.die_type);
                realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    weapon.setWeaponDamageDieType(position);
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
});