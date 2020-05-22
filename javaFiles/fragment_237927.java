DATA = context.getSharedPreferences(APP_DATA, Context.MODE_PRIVATE);
    Editor = DATA.edit();

}

@Override
protected void onPreExecute() {
    super.onPreExecute();

}

@Override
protected Void doInBackground(Void... params) {