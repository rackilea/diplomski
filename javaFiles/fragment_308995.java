if(isExpanded) {
        convertView.setBackgroundResource(R.drawable.selectedlistback);
        tv_title.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
    }else{
        convertView.setBackgroundResource(R.drawable.listback);
        tv_title.setTextColor(context.getResources().getColor(R.color.colorAccent));
    }