public class ContractAdapter extends ArrayAdapter<Contract> {


private List<Contract> contracts;

public ContractAdapter(Context context, int view, List<Contract> passedContracts) {
        super(context, view, passedContracts);
        contracts = passedContracts;
}

@Override
public int getCount() {
    return contracts.size();
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        View currentView = convertView;
        LayoutInflater currentViewInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        currentView = currentViewInflater.inflate(R.layout.deal_list, null);
        Contract currentContract = contracts.get(position);
        TextView text = (TextView) currentView.findViewById(R.id.text1);
        text.setText(currentContract.getName());
        return currentView;
}