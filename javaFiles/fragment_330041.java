final TextView tvDialogDelete = (TextView) dialog.findViewById(R.id.tvDialogDelete);

    final DBHandler dba = new DBHandler(MainActivity.this);

        tvDialogDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DBPodatci infoData = dbPodatci.get(i);
                final int idToDelete = infoData.getItemId();

                dbPodatci.remove(i);  
                dba.obrisiTrening(idToDelete);

                vjezbaAdapter.notifyDataSetChanged();
                dialog.dismiss();