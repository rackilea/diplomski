public void LoadData (DataSnapshot dataSnapshot)

        {            

        System.out.println(ds.getValue());

        ModelClass doc =ds.getValue(ModelClass.class);

       doctors.add(doc);

       adapter = new MyAdapter(MainActivity.this, doctors);
        recyclerView.setAdapter(adapter);
    }
}