EditText data = (EditText) findViewbyId(R.id.edittext);

String result = data.getText().toString(); //Take URL from edittext

if (!result.startsWith("http://") && !result.startsWith("https://"))
      result = "http://" + result;