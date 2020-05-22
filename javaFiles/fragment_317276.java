if (currentView == 1) {
  String test="";
  for (Contact cn : contacts) {
    TextView asd = (TextView) rootView.findViewById(R.id.section_label);
    test += "Id: " + cn.getID() + cn.getJokeCat01();
    System.out.println(test);

  } // end of for

  Witze.setText(test);

}  // end of if