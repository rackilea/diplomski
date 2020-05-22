holder.plantName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onTitleClicked(holder.getAdapterPosition(), plants.get(position).getSpecie(), view);
                    }
                }
            });

 holder.plantPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClicked(holder.getAdapterPosition(), view);
                    }
                }
            });
        }
    }