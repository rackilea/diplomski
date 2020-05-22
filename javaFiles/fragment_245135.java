void updateParameterString () {
   String parameterString = ""; // constant params can be initialized here too
   if (checkbox1 is checked) parameterString += " -arg1";
   if (checkbox2 is checked) parameterString += " -arg2";
   if (checkbox3 is checked) parameterString += " -arg3";
   if (checkbox4 is checked) parameterString += " -arg4";
   CustDEVARGSargsTextField.setText(parameterString); // option: trim the string
}

void onAnyCheckButtonStateChange () {
   updateParameterString();
}