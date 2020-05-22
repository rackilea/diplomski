holder.title.setTag(position);
    holder.title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                                int pos = (int) view.getTag();
                                setSelectedPosition(pos);
                            }
                        }