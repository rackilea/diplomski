public class FormsViewHolder extends RecyclerView.ViewHolder {

public View view;
public FormsViewHolder(View itemView) {
    super(itemView);
    view=itemView;
}
public void setFormsData(UserForm userForm)
{
    // initialise card views items and set value in them
    TextView userName=(TextView)view.findViewById(R.id.userName);
    userName.setText(userForm.getName());
}}