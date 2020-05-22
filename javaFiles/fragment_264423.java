SharedPreferences accountsPref = PreferenceManager.getDefaultSharedPreferences(this);
if (accountsPref.contains("newAccount")) {
    Gson gson = new Gson();
    String json = accountsPref.getString("newAccount", "");
    Account newAccount = gson.fromJson(json, Account.class);
    accounts.add(newAccount);
}