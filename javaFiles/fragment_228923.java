public class HCPListAdapter extends ArrayAdapter<User> {
List<User> users;
LayoutInflater inflater;

public HCPListAdapter(Activity context, int resouceId, int textviewId, List<User> list){
    super(context,resouceId,textviewId, list);
    users = list;
    inflater = context.getLayoutInflater();
}

@NonNull
@Override
public View getView(int position, View convertView, @NonNull ViewGroup parent) {

    if (convertView == null) {
        convertView = inflater.inflate(R.layout.hcp_dropdown, parent, false);
    }
    TextView name = convertView.findViewById(R.id.Row_assessment_file_for_list_assessment_text_name);

    User user = getItem(position);
    if (user != null) {
        name.setText(user.getTitle() + ". " + user.getLastname() + ", " + user.getFirstname());
    } else {
        name.setText(R.string.error_unknown);
        return convertView;
    }
    return convertView;
}

@Override
public int getCount() {
    return users.size();
}

@Override
public View getDropDownView(int position, View convertView, ViewGroup parent) {
    if(convertView == null){
        convertView = inflater.inflate(R.layout.hcp_dropdown, parent, false);
    }
    User user = getItem(position);
    TextView txtTitle = convertView.findViewById(R.id.Row_assessment_file_for_list_assessment_text_name);
    txtTitle.setText(user.getTitle() + ". " + user.getLastname() + ", " + user.getFirstname());
    return convertView;
    }
}