if(Fragment.List.get(holder.getAdapterPosition()).isTrueBtnClicked){
            holder.btnPositive.setEnabled(false);
            holder.btnPositive.setBackgroundResource(R.color.darkGray);
            holder.btnNegative.setEnabled(false);
            holder.btnNegative.setBackgroundResource(R.color.darkGray);

        }else{
            holder.btnPositive.setEnabled(true);
            holder.btnPositive.setBackgroundResource(R.color.greenEnable);
            holder.btnNegative.setEnabled(true);
            holder.btnNegative.setBackgroundResource(R.color.greenEnable);
        }