@Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {

       itemViewHolder.amount.setText(items.get(i).amount);
       itemViewHolder.expense.setText(items.get(i).expense);

       if(getItemViewType(i) == 1){
        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .withBorder(4)
                .textColor(Color.BLACK)
                .useFont(Typeface.DEFAULT)
                .fontSize(25)
                .bold()
                .toUpperCase()
                .endConfig()
                .buildRound("11:00", Color.GRAY);
        itemViewHolder.small.setImageDrawable(drawable);
       }else{
        TextDrawable drawable1 = TextDrawable.builder()
                .beginConfig()
                .withBorder(4)
                .textColor(Color.BLACK)
                .useFont(Typeface.DEFAULT)
                .fontSize(25)
                .bold()
                .toUpperCase()
                .endConfig()
                .buildRound("10 Jan", Color.CYAN);
        itemViewHolder.big.setImageDrawable(drawable1);
      }
    }