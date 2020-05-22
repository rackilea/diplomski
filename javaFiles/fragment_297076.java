public class FormsAdapter extends RecyclerView.Adapter<FormsViewHolder> {
private ArrayMap<String,UserForm> formsList=new ArrayMap<>();
/*use arrayMap to get from data and key */
public FormsAdapter() {
formsList=new ArrayMap<>();
}

@Override
public FormsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    // inflating card view item
    View v = inflater.inflate(R.layout.form_card, parent, false);
    return new FormsViewHolder(v);
}

@Override
public void onBindViewHolder(FormsViewHolder holder, int position) {
    String itemKey=formsList.keyAt(position);
    UserForm userForm=formsList.get(itemKey);
    // set one forms data
    holder.setFormsData(userForm);
    holder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // handle click event
        }
    });
}

@Override
public int getItemCount() {
    return formsList.size();
}

public void addAFormItem(String key,UserForm userForm)
{
    if (!formsList.containsKey(key))
    {
        formsList.put(key,userForm);
        notifyItemInserted(formsList.size());
    }
} }