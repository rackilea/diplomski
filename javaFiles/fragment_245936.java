personasViewHolder.card_view.setOnLongClickListener(new View.OnLongClickListener() {
@Override
public boolean onLongClick(View v) {
Toast.makeText(v.getContext(), "Eliminar Cardview", Toast.LENGTH_SHORT).show();



personasViewHolder.card_view.setBackgroundResource(R.color.colorPrimary);
            globalPosition=i;
            notifyDataSetChanged();
            return false;
        }
    });