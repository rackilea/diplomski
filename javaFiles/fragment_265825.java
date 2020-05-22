@Override
        public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dSnapshot : snapshot.getChildren()) {

                    StreetClass streetClass = dSnapshot.getValue(StreetClass.class);
                    Log.d("Show", streetClass.getSname() == null ? "" : streetClass.getSname());
                    list.add(streetClass);

                }

                adapter = new StreetAdapter(ShowStreetDetails.this, list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
        }