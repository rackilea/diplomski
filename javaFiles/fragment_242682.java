@Override
public void onLoadFinished(Loader<List<Soluzione>> loader, List<Soluzione> data) {
    try {
    pd.dismiss();
     } catch(Exception e){  
    }

    if (data == null) {
    // ERRORE
    } else {
    SoluzioniAdapter adapter = new SoluzioniAdapter(SoluzioniActivity.this, partenze, arrivi, date);
mListView.setAdapter(adapter);
}