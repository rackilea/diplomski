public class CardBackFragment extends Fragment implements OnClickListener
{

    public CardBackFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_coindice, container, false);
        v.findViewById(R.id.coin2).setOnClickListener(this);
        return v;
    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.coin2:
            break;
        }
    }
}