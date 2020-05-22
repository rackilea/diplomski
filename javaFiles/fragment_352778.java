private class ALItensValuesAdapter extends BaseAdapter {
   private ArrayList<ALItensValues> mData;
   private Context mContext;
   private MyInterface interface;

   ALItensValuesAdapter(ArrayList<ALItensValues> aldata, Context context, MyInterface interface) {
      this.mData = aldata;
      this.mContext = context;
      this.interface = interface;
   }

   @Override
   public int getCount() {
      return mData.size();
   }

   @Override
   public Object getItem(int position) {
      return null;
   }

   @Override
   public long getItemId(int position) {
       return 0;
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
           LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
           convertView = Objects.requireNonNull(mInflater).inflate(R.layout.multipleselectcustom_lines, null);
        }

        ImageView icon = convertView.findViewById(R.id.imgvicon);
        icon.setImageResource(mData.get(position).getIcon());
        TextView titulo = convertView.findViewById(R.id.txtv_titulo);
        titulo.setText(mData.get(position).getTitulo());
        TextView decricao = convertView.findViewById(R.id.txtv_desc);
        decricao.setText(mData.get(position).getDescricao());
        CheckBox checkbox = convertView.findViewById(R.id.chkbox);
        if(mData.get(position).getChecked()) {
             checkbox.setChecked(true);
        } else {
             checkbox.setChecked(false);
        }
        convertView.setOnClickListener(v -> {
            this.interface.onItemChecked(position);
            checkbox.toggle();
        });
   return convertView;
  }
}