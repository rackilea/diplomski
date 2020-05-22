...
  String result = data.getData().getAttributes().getName();
                Log.d(TAG, "onResponse: " + result);

                sp.edit().putString(CATEGORY_NAME, result).commit();
String info;
info = sp.getString(CATEGORY_NAME, "");

String result = getString(R.string.type) + data.getData().getType() + "\n"
                + getString(R.string.id) + data.getData().getId() + "\n"
                + getString(R.string.amount) + 
                data.getData().getAttributes().getAmount() + "\n"
               + getString(R.string.remark) + 
               data.getData().getAttributes().getRemark() + "\n"
               + getString(R.string.name) + 
              data.getData().getAttributes().getName() + "\n"
              + getString(R.string.date) + 
               data.getData().getAttributes().getDate() + "\n"
               getString(R.string.category) + info;

                        popUpWindow(result);
                        editor.clear();
                        editor.commit();