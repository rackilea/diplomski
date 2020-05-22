LayoutInflater inflater = getLayoutInflater();
View dialoglayout = inflater.inflate(R.layout.notificaton_setting, null);
dialogLayout.findViewById(R.id.time).setOnClickListener(...)

AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setView(dialoglayout);
builder.show();