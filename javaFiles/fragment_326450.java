holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                build.setSelected(!build.isSelected());
                if (build.isSelected()) {
                    holder.button.setBackgroundResource(R.drawable.selected_true_icon_new);
    Intent intent = new Intent(context, youractivity.class)
    intenet.putExtra("key","value");
    context.startActivity(intent);
                } else
                    holder.button.setBackgroundResource(R.drawable.add_button_icon);
            }
        });