public void sendListeAndMakeAffichage(final List<String> sourceList,final List<String> sourceTitre, final String newEntry) {

    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            listTitre.add(newEntry); // Now we manipulate the list in this runnable
            // While the next call to the fragment will finish updating the adapter
            // and call notifyDataSetChanged()
            fragmentListe.setListTitreAndListSource(sourceTitre, sourceList);

        }
    });

}