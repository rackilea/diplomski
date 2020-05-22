protected void onPostExecute(String result) {
        Activity myActivity = getActivity();
        if (myActivity==null) return; // Fragment not active anymore, bail out
        adapter = new ParsingArrayAdapter(myActivity, titoli, descrizioni,immagini);
        lista.setAdapter(adapter);
}