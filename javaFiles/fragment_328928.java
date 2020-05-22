myAdapter.setViewBinder(new MyViewBinder());

public class MyViewBinder implements ViewBinder {
    @Override
    public boolean setViewValue(View view, Object data, String text){
        if(view instanceof TextView){
            ((TextView)view).setText(String.format("You have %s books overdue",text));
        }
    }
}