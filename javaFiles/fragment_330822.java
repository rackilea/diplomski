cowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int color = colorUtils.thisWasClicked(cowViewHolder);
            if (color > 0) {
                gd.setColor(ContextCompat.getColor(context, color));
            }
            if (color < 0) {
                gd.setColor(Color.WHITE);
                exclamation.setVisibility(View.GONE);
                smily.setVisibility(View.VISIBLE);

            }