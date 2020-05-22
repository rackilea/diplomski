@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    ....

    // use alerte_trimise instead of getView()
    list_view_alerte_trimise = alerte_trimise.findViewById(R.id.list_view_alerte_trimise);


    //use activityContext instead of this
    Creare_istoricAdapter adapter = new Creare_istoricAdapter(activityContext, R.layout.istoric_alerte_adapter, alerteTrimise);

    ....

    return alerte_trimise;
}