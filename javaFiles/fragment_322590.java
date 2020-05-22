// use the current state to create the view
            String text;
            if (expanded[position]) {
                text = jsonObject.getString("post") + "... Read Less";
            } else {
                text = jsonObject.getString("post").substring(0, 13) + "...Read More";
            }
            holder.post.setText(text);
            holder.post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // update the current state and request list refresh
                    expanded[position] = ! expanded[position];    // toggle
                    notifyDataSetChanged();
                }
            });