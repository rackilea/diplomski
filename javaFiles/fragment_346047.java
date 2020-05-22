public class VanzatorProduseList extends ArrayAdapter<VanzatorProduse> {

    private Activity context;
    private List<VanzatorProduse> vanzatorProduseList;
    private double total = 0.0;


    public VanzatorProduseList(Activity context, List<VanzatorProduse> vanzatorProduseList) {
        super(context, R.layout.list_produse_vanzator, vanzatorProduseList);
        this.context = context;
        this.vanzatorProduseList = vanzatorProduseList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_produse_vanzator, null, true);
        final TextView textViewProdus1 = (TextView) listViewItem.findViewById(R.id.textViewProdus1);
        final TextView textViewPret1 = (TextView) listViewItem.findViewById(R.id.textViewPret1);
        final TextView textViewCantitate1 = (TextView) listViewItem.findViewById(R.id.textViewCantitate1);
        final VanzatorProduse vanzatorProduse = vanzatorProduseList.get(position);
        textViewProdus1.setText(vanzatorProduse.getProdus());
        textViewPret1.setText(vanzatorProduse.getPret());
        textViewCantitate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                LayoutInflater inflater = context.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_alert, null);
                dialogBuilder.setView(dialogView);
                final ElegantNumberButton elegantNumberButton = (ElegantNumberButton) dialogView.findViewById(R.id.elegantNumberButton);
                final Button dialog_btn = (Button) dialogView.findViewById(R.id.dialog_btn);
                dialogBuilder.setTitle("Alege cantitate : " + vanzatorProduse.getProdus());
                final AlertDialog b = dialogBuilder.create();
                b.show();
                dialog_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String num = elegantNumberButton.getNumber();
                        total = (Integer.parseInt(vanzatorProduse.getPret()) * (Integer.parseInt(num)));
                        textViewPret1.setText(String.valueOf(total));
                        textViewCantitate1.setText(num);
                        b.dismiss();

                          vanzatorProduse.setSubTotal(total);

                         Toast.makeText(context, "total : " + calculateTotal(), Toast.LENGTH_LONG).show();


                    }
                });
            }
        });
        return listViewItem;
    }


    public int calculateTotal(){
        int total = 0;
        for(VanzatorProduse vanzator: vanzatorProduseList){
            total+=  vanzator.getSubTotal();
        }
        return total;
    }

}