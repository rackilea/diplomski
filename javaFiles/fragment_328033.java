for (int i =  0; i < Name.size(); i++){
    name.setText(Name.get(i).toString);
    if (i < Mobile.size()) {
       mobile.setText(Mobile.get(i).toString);
    } else {
        mobile.setVisibility(View.GONE);
    }
}