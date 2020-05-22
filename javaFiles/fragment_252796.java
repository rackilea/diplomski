public void onActivityCreated(Bundle savedInstanceState) {

    adapter = new CustomListAdapterHoraires(this, horairesList);
    listView3.setAdapter(adapter);

}