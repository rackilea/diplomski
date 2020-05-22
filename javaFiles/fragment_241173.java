@Override
public void afterTextChanged(Editable s) {
Log.d("DEBUG", "afterTextChanged : "+s);
String ccNum = s.toString();
   for(String p:listOfPattern){
      if(ccNum.matches(p)){
         Log.d("DEBUG", "afterTextChanged : discover");
         break;
      }
   }
}