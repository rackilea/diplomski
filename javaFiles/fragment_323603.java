holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int i = exList.get(position).count;
                    holder.tv.setText(String.valueOf(i++));
                    exList.get(position).count = i;
            }
        });
holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = exList.get(position).count;
                holder.tv.setText(String.valueOf(i--));                         exList.get(position).count = i;
            }
        });