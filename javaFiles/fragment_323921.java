public class SettingFragment extends Fragment{

private View rootView;
Spinner spinner;
ArrayAdapter<CharSequence> adapter;

public SettingFragment(){
    //required empty public constructor
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_setting, container, false);
    spinner = (Spinner)rootView.findViewById(R.id.spinner);

    return rootView;
}

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    adapter = ArrayAdapter.createFromResource(getActivity(), R.array.select_font_size, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
    }
}