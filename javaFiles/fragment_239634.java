final TitleHolder holder = (TitleHolder) h;
        final Model model = (Model) mdataSet.get(position);

        holder.txt_title.setText(model.getTitle());
        holder.childItem = model;

        holder.txt_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.getChildList() == null) {
                    //collapse
                    ((Model) mdataSet.get(mdataSet.indexOf(holder.childItem))).isExpanded = false;
                    holder.arrow.startAnimation(AnimationUtils.loadAnimation(context, R.anim.arrow_reverse));
                    model.childList = new ArrayList<ModelData>();
                    int count = 0;
                    int pos = mdataSet.indexOf(holder.childItem);
                    while (mdataSet.size() > pos + 1 && mdataSet.get(pos + 1).type == Model.VIEW_CHILD) {
                        model.childList.add((ModelData) mdataSet.remove(pos + 1));
                        count++;
                    }
                    notifyItemRangeRemoved(pos + 1, count);
                } else {
                    //expand
                    ((Model) mdataSet.get(mdataSet.indexOf(holder.childItem))).isExpanded = true;
                    holder.arrow.startAnimation(AnimationUtils.loadAnimation(context, R.anim.arrow));
                    int pos = mdataSet.indexOf(holder.childItem);
                    int index = pos + 1;
                    for (ModelData i : model.getChildList()) {
                        mdataSet.add(index, i);
                        index++;
                    }
                    notifyItemRangeInserted(pos + 1, index - pos - 1);
                    model.childList = null;

                }

            }
        });

        if (((Model) mdataSet.get(mdataSet.indexOf(holder.childItem))).isExpanded) {
            holder.arrow.startAnimation(AnimationUtils.loadAnimation(context, R.anim.arrow));
        }