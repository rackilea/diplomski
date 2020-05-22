@OnClick({R.id.next,R.id.country_us,R.id.country_india})
public void nextClicked(View view)
{ switch(view.getId()) {
    case R.id.next:
        Intent intent = new Intent(this, TutorialScreen.class);
        intent.putExtra("country_selected", ind_sel);
        startActivity(intent);
        break;
    case R.id.country_india:
        ind_sel=true;
        setselectedBlank();
        view.setBackgroundResource(R.drawable.selected_border);
        break;

    case R.id.country_us:
        ind_sel=false;
        setselectedBlank();
        view.setBackgroundResource(R.drawable.selected_border);
        break;
}
}


private void setselectedBlank() {
    country_us.setBackgroundResource(R.drawable.border);
    country_india.setBackgroundResource(R.drawable.border);
}