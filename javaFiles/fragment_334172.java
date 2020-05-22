public class MyOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent,
        View view, int pos, long id) {
        if (parent.getItemAtPosition(pos).toString().equals("firstMovieName")) {
            // set spinner B/C/D with the corresponding information of first movie
        }
    }

    public void onNothingSelected(AdapterView parent) {
      // Do nothing.
    }
}