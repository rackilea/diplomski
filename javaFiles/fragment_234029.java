.....
 holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     // no neeed this condition
                    //if (PizzaActivity.class != null){
                    if(position == 0){
                        Intent intent = new Intent(activity, Pizza1Activity.class);
                        activity.startActivity(intent);
                    }
                    if(position == 1){
                        Intent intent = new Intent(activity, Pizza2Activity.class);
                        activity.startActivity(intent);
                    }
                    if(position == 2){
                        Intent intent = new Intent(activity, Pizza3Activity.class);
                        activity.startActivity(intent);
                    }
                }
        });