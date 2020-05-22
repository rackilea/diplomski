String strSelectedValueFromSpinner = getArguments().getString("spinnerText");
View theDIalog = inf.inflate(R.layout.makea_transfer_confirm, null);
builder.setView(theDIalog);
// get TextView here
TextView spinnerText = (TextView) theDIalog.findViewById(R.id.spinnerSelectedText);
spinnerText.setText(strSelectedValueFromSpinner);