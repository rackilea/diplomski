ArrayList<HashMap<String, String>> numberList = null;
Bundle bundle = getIntent().getExtras();
Intent intent = getIntent();
if(bundle!=null)
{
    numberList = (ArrayList<HashMap<String, String>>) bundle.getSerializable("map");
}