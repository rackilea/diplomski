public void SaveInsult(View view) {
    String saved = insult.getText().toString();
        if (oldfavs.contains(saved)) {
            Toast.makeText(getApplicationContext(), R.string.alreadyinfavs, Toast.LENGTH_SHORT).show();
        }else {
            oldfavs.add(saved);
            Toast.makeText(getApplicationContext(), R.string.addedfavs, Toast.LENGTH_SHORT).show();
        }
}