View page1 = mPagerAdapter.getViewAtPosition(0);
View page2 = mPagerAdapter.getViewAtPosition(1);
View page3 = mPagerAdapter.getViewAtPosition(2);

if (getArguments() != null) {
    ((EditText) page1.findViewById(R.id.IDName)).setText(getArguments().getString("name"));
    ((EditText) page2.findViewById(R.id.IDIPaddress)).setText(getArguments().getString("ip"));
    ((EditText) page2.findViewById(R.id.IDPort)).setText(getArguments().getString("port"));
    ((EditText) page3.findViewById(R.id.IDUsername)).setText(getArguments().getString("username"));
    ((EditText) page3.findViewById(R.id.IDPassword)).setText(getArguments().getString("pass"));
}