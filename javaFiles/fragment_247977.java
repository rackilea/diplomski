public class CheckBoxListener implements OnCheckedChangeListener {

    public CheckBoxListener() {

    }


    @Override
    public void onCheckedChanged(CompoundButton view, boolean isChecked) {
        switch(view.getId()) {
        case R.id.checkBox1: 
            //do something
        case R.id.checkBox2:

        case ...
        }

    }
}