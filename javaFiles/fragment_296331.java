holder.lay_row.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int type = transaction.get(holder.getAdapterPosition()).typeToDisp;
            if (type == 0)
                { 
                   transaction.get(holder.getAdapterPosition()).typeToDisp = 1;
                   notifyItemChanged(holder.getAdapterPosition())
                } 

        }
    });