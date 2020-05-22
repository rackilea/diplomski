public class MyCallback implements Callback<Data>{

    private View view;

    public MyCallback(View view){
        this.view = view;
    } 

    @Override
    onResponse(Data data) {
        view.showData(data);
    }
}