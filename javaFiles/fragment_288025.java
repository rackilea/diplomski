@Override
protected void onPostExecute(final List<FootballModel> result) {
    super.onPostExecute(result);

    tabelleFragment.onParseFinished(result);
}