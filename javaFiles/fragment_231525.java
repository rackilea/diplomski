public String doInBackground(String[] params) {
    .... // don't set hash here ... it will work but you will probably read it at the wrong time.
    return str;
}

public void onPostExecute(String str) {
    onHashComplete(str); // or just do all the work in here since it is a private inner class
}