class CustomListView extends BaseAdapter {

    private ArrayList<ListItem2> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListView adapter = this;
    String jmlCmbSiap;
    ArrayList<String> a = new ArrayList<>();

    private boolean[] checkBoxState;
    private Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();

    public CustomListView(Context context, ArrayList<ListItem2> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        checkBoxState = new boolean[listData.size()];
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        newsItem = listData.get(position);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_detail_order, null);
            holder = new ViewHolder();
            newsItem.setAdapter(Integer.parseInt(newsItem.getJumlah()));
            holder.txtBarang = (TextView) convertView.findViewById(R.id.txtBarang);
            holder.txtJumlah = (TextView) convertView.findViewById(R.id.txtJumlah);
            holder.txtBox = (TextView) convertView.findViewById(R.id.txtBoxes);
            holder.cmbSiap = (Spinner) convertView.findViewById(R.id.cmbSiap);
            holder.cmbSiap.setAdapter(newsItem.getAdapter());
            holder.thumbImage = (ImageView) convertView.findViewById(R.id.thumbImage);
            holder.chkOk = (CheckBox) convertView.findViewById(R.id.chkOk);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.checkBox.setChecked(checkBoxState[position]);

        if (checkBoxState[position])
        {
            holder.chkOk.setChecked(true);
            newsItem.setcmbSiap(true);
            newsItem.settxtBox(true);

            holder.cmbSiap.setEnabled(true);   
            holder.cmbSiap.setClickable(true); 

            txtBox.setEnabled(true);
        }
        else
        {
            holder.chkOk.setChecked(false);
            newsItem.setcmbSiap(false);
            newsItem.settxtBox(false);

            holder.cmbSiap.setEnabled(false);   
            holder.cmbSiap.setClickable(false); 

            txtBox.setEnabled(false);
        }

        Picasso
                .with(context)
                .load(newsItem.getImg())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.thumbImage);


        holder.txtBarang.setText(newsItem.getNamaProduk().toUpperCase());
        holder.txtJumlah.setText(newsItem.getJumlah().toUpperCase());

        holder.cmbSiap.setSelection(Integer.parseInt(newsItem.getJumlah()));
        holder.cmbSiap.setEnabled(newsItem.getcmbSiap());
        holder.txtBox.setEnabled(newsItem.gettxtBox());

         if (myMap.containsKey(position)) {
            viewHolder.spinner.setSelection(myMap.get(position));
        }

        holder.cmbSiap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                jmlCmbSiap = parent.getItemAtPosition(position).toString();
                newsItem.setJumlah(jmlCmbSiap);

                myMap.put(position, pos);

                System.out.println("JML : " + newsItem.getJumlah());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        holder.chkOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkOk checked?
                if (((CheckBox) v).isChecked()) {
                    checkBoxState[position] = true;
                    viewHolder.spinner.setEnabled(true);
                    viewHolder.spinner.setClickable(true);
                } else {
                    checkBoxState[position] = false;
                    viewHolder.spinner.setEnabled(false);
                    viewHolder.spinner.setClickable(false);
                }
            }
        });

        cmdPak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.clear();
                for (int i = 0; i < listData.size(); i++)
                {
                    newsItem = listData.get(i);
                    a.add(newsItem.getJumlah().toString());
                }
                System.out.println("Pak : " + a);
            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView txtBarang,txtJumlah,txtBox;
        Spinner cmbSiap;
        ImageView thumbImage;
        CheckBox chkOk;

    }
}