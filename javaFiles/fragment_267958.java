public class UserRecyclerAdapterSavedUsers extends RecyclerView.Adapter<UserRecyclerAdapterSavedUsers.UserViewHolder> {

private List<User> listUsers;
Context mContext;
ItemClickListenerLongPressed itemClickListenerLongPressed;
View itemView;

public UserRecyclerAdapterSavedUsers(List<User> listUsers) {
this.listUsers = listUsers;
}


@Override
public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType)       {
itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_user_recycler_second, parent, false);

return new UserViewHolder(itemView);
}



@Override
public void onBindViewHolder(UserViewHolder holder, int position) {
holder.textViewID.setText(listUsers.get(position).getUserid());
holder.textViewName.setText(listUsers.get(position).getName());
holder.textViewPassword.setText(listUsers.get(position).getPassword());
holder.textViewRole.setText(listUsers.get(position).getRole());

}

public void setItemClickListenerLongPressed(ItemClickListenerLongPressed itemClickListenerLongPressed){
this.itemClickListenerLongPressed=itemClickListenerLongPressed;
}

@Override
public int getItemCount() {
return listUsers.size();
}

private void displayingAlertDialog() {
    //displaying alert dialog box
    AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
    builder.setMessage("your toast message here...");
    builder.setCancelable(true);

    builder.setPositiveButton(
            "Ok",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();

                }
            });

    AlertDialog alert11 = builder.create();
    alert11.show();
}

/**
 * ViewHolder class
 */
public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//public AppCompatTextView ID;
public AppCompatTextView textViewID;
public AppCompatTextView textViewName;
public AppCompatTextView textViewPassword;
public AppCompatTextView textViewRole;
LinearLayout layout;

public UserViewHolder(View view) {
    super(view);

    textViewID = (AppCompatTextView) view.findViewById(R.id.textViewID);
    textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
    textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
    textViewRole = (AppCompatTextView) view.findViewById(R.id.textViewRole);
    layout = view.findViewById(R.id.list_view);

    layout.setOnClickListener(this);
}

@Override
public void onClick(View v) {
    displayingAlertDialog();
}
}