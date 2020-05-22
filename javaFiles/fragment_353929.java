databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (!dataSnapshot.exists())
                return;
            UserProfil userProfil = dataSnapshot.getValue(UserProfil.class);
            profilVorname.setText(userProfil.getVorname());
            profilNachname.setText(userProfil.getNachname());
            profilStrasse.setText(userProfil.getStrasse());
            profilHNr.setText(userProfil.getHnr());
            profilPlz.setText(userProfil.getPlz());
            profilStadt.setText(userProfil.getStadt());
            profilLand.setText(userProfil.getLand());

        }