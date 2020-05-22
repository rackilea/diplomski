public class PersonasAdapter extends RecyclerView.Adapter < PersonasAdapter.PersonasViewHolder > {

private Persona subject;
private List < Persona > personastList;
public PersonasAdapter() {}
int globalPosition;

public PersonasAdapter(List < Persona > personastList) {
this.personastList = personastList;
}


@Override
public void onBindViewHolder(final PersonasViewHolder personasViewHolder, final int i) {
Persona ci = personastList.get(i);
personasViewHolder.txtNombre.setText(ci.getNombre());
personasViewHolder.txtUsuario.setText(ci.getUsuario());
personasViewHolder.txtTwitter.setText(ci.getTwitter());
subject = personastList.get(i);


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
personasViewHolder.card_view.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Toast.makeText(v.getContext(), "Reproducir", Toast.LENGTH_SHORT).show();
}
});



if(i==globalPosition)
{
//change color like
personasViewHolder.card_view.setBackgroundResource(R.color.colorPrimary);


}
else
{
personasViewHolder.card_view.setBackgroundResource(R.color.colorAccent);
}

}
@Override
public PersonasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout_persona, viewGroup, false);

return new PersonasViewHolder(itemView);
}
public static class PersonasViewHolder extends RecyclerView.ViewHolder {
protected TextView txtNombre;
protected TextView txtUsuario;
protected TextView txtTwitter;
protected CardView card_view;

public PersonasViewHolder(View v) {
super(v);
txtNombre = (TextView) v.findViewById(R.id.txtNombre);
txtUsuario = (TextView) v.findViewById(R.id.txtUsuario);
txtTwitter = (TextView) v.findViewById(R.id.txtTwitter);
card_view = (CardView) v.findViewById(R.id.card_view);
}
}
//Metodo que nos retornarta la cantidad de personas en la lista
@Override
public int getItemCount() {
return personastList.size();
}
}