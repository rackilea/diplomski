View dialogBody = inflater.inflate(R.layout.dlg_option, null);
mDisplayDate = (TextView) dialogBody.findViewById(R.id.txt_time);
mDisplayDate.setOnClickListener(new View.OnClickListener() {
    ...
});
builder.setView(dialogBody);