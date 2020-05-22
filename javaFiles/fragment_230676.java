@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
{
    super.onCreateView(inflater, container, savedInstanceState);
    if(rootView != null)
    {
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
        {
            parent.removeView(rootView);
        }
    }
    try
    {
        // Creating view
        rootView = inflater.inflate(R.layout.fragment_ssorubir, container, false);

    }
    catch(Exception e)
    {

    }

    // Here befor returning the view set your onClickListener
    rootView.setOnClickListener(yourOnClickListener);

    return rootView;
}