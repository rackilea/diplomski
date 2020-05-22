if(array.get(i).contain("Me")){
    String value = array.get(i).split(":")[0];
    String value1 = array.get(i).split(":")[1];
    String main_value = "<b>"+value +":</b> "+ value1;

    txt.setText( Html.fromHtml(main_value));
}