public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        MaterialButtonToggleGroup Tabs;
        MaterialButton Prn_Btn;
        OnButtonListener onButtonListener;
        public ViewHolder(@NonNull View itemView, final OnButtonListener onButtonListener) {
            super(itemView);
            Tabs = itemView.findViewById(R.id.toggleGroup);
            this.onButtonListener = onButtonListener;
            int toggleGroupID = Tabs.getCheckedButtonId();
            Prn_Btn = itemView.findViewById(toggleGroupID);
            itemView.setOnClickListener(this);

            Tabs.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
                @Override
                public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                    if (onButtonListener != null){
                        if (isChecked){
                            int position = getAdapterPosition();
                            onButtonListener.ontabClick(position, checkedId);
                        }
                        if (Tabs.getCheckedButtonId() == -1){
                            int position = getAdapterPosition();
                            onButtonListener.ontabClick(position, -1);
                        }
                    }
                }
            });
        }