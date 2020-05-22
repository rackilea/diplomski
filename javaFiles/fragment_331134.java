@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    LinearLayout ll = (LinearLayout) view;
    //This will give you the string value of selected list item
    TextView listItem = (TextView) ll.getChildAt(0);
    //You can do this or apply own logic to find the selected value case
    Switch(listItem.getText().toString()) {
      case "bateria 9v": 
         Intent myintent0 = new Intent(view.getContext(), Main2Activity.class);
         startActivityForResult(myintent0, 0);
         break;
      case "pila 9v":
         Intent myintent1 = new Intent(view.getContext(), Main3Activity.class);
         startActivityForResult(myintent1, 1);
         break;
         //...

    }
    //or if condition
    if(listItem.getText().toString().equals(values[0]) {
      Intent myintent0 = new Intent(view.getContext(), Main2Activity.class);
      startActivityForResult(myintent0, 0);
    }
}