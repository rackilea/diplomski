@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    String textDisplayedByCurrentItem = ((TextView) view).getText();

    if(textDisplayedByCurrentItem.equals(daftar[0]) { // or .equals("1")
            intent.putExtra("Tit", "Error Code");
            intent.putExtra("text1","Title 1");
            intent.putExtra("text2","Error 1ccccc");
            startActivity(intent);
    } else if (textDisplayedByCurrentItem.equals(daftar[1]) {  // or .equals("2")
            intent.putExtra("Tit", "Error Code");
            intent.putExtra("text1","Title 2");
            intent.putExtra("text2","Error 2cccc");
            startActivity(intent);
    }
}