public class ListaItensAdapter extends ArrayAdapter<ItemEstoque>  {
private Context context;
private List<ItemEstoque> itens = null;
private List<ItemEstoque> itens_exibicao = null;
Filter f;

public ListaItensAdapter(Context context, List<ItemEstoque> itens) {
    super(context, 0, itens);
    this.itens = itens;
   this.itens_exibicao = new ArrayList<ItemEstoque>();
        this.itens_exibicao.addAll(itens);
    this.context = context;
}

@Override
public View getView(int position, View view, ViewGroup parent) {
    ItemEstoque item = itens.get(position);

    if (view == null)
        view = LayoutInflater.from(context).inflate(R.layout.item_list_estoque, null);

    TextView textViewNomeProduto = (TextView) view.findViewById(R.id.text_view_nome);
    textViewNomeProduto.setText(item.getNomeProduto());
    TextView textViewPreco = (TextView) view.findViewById(R.id.text_view_preco);
    textViewPreco.setText(Float.toString(item.getValorUnitarioProduto()));

    return view;

}

public void getfilter(String charText) {
charText = charText.toLowerCase(Locale.getDefault());
itens.clear();
if (charText.length() == 0) {
itens.addAll(itens_exibicao);
}
else
{
for (ItemEstoque m : itens_exibicao)
{
if (m.getNomeProduto().toLowerCase(Locale.getDefault()).contains(charText))
{
itens.add(m);
}
}
}
notifyDataSetChanged();
}


}