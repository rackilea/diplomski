try
{
    JSONArray jsonArray = new JSONArray(jsonData);
    // ...
    Toast.makeText(MainActivity.this, jsonData.get(1), Toast.LENGTH_LONG).show();
}
// ...