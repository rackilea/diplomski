public class FragmentA extends Fragment implements SendData {
private TextView textView, textView2,textView3,textView4;

View view ;
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_a,container,false) ;

    textView4= (TextView) view. findViewById(R.id.textIsım);
    textView3= (TextView) view.findViewById(R.id.textView3);
    textView2= (TextView) view.findViewById(R.id.textView2);
    textView= (TextView) view. findViewById(R.id.textView);
    if(getActivity() instanceOf MainActivity)
       (MainActivity)getActivity().setSendData(this);  //set your interface in MainActivity
    return view;
}

@Override
public void gonder(String isim) {
    Factory.getInstance().havaModel(isim,APPID_KEY).enqueue(new Callback<HavaModel>() {
        @Override
        public void onResponse(Call<HavaModel> call, Response<HavaModel> response) {
            textView.setText(Float.toString((float) (response.body().main.temp-273.15)));
            textView2.setText(Float.toString(response.body().coord.lon));
            textView3.setText(Integer.toString(response.body().main.humidity)+" %");
            textView4.setText(response.body().name);

        }

        @Override
        public void onFailure(Call<HavaModel> call, Throwable t) {

        }
    });
}