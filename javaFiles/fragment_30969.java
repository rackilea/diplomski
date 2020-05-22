holder.ivHeart.setOnClickListener(v -> {
                if(list.isfav) {
                 list[adapterPosition].isfav = false;
                }else{
               list[adapterPosition].isfav = true;
                }
               notifyItemChanged(adapterPosition);
           });