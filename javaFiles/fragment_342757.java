holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ChatActivity.class);
                i.putExtra("visit_user_id", userIDs);
                i.putExtra("visit_user_name", profileName);
                i.putExtra("visit_image", userImage);
                startActivity(i);
            }
       });