public View getView(final int position, final View convertView, ViewGroup parent) {
        View row = convertView;


        RowBeanHolder holder;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);

            holder = new RowBeanHolder();
            holder.txtTitle=(TextView) row.findViewById(R.id.name);
            holder.indicator=(TextView) row.findViewById(R.id.indicator);
            holder.checkBox=(CheckBox) row.findViewById(R.id.checkBoxDelete);
            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int itemPos = buttonView.getTag();
                    ProductList element = data.get(itemPos);
                    element.setSelected(isChecked);
                    //Toast.makeText(context,element.getSelected(),Toast.LENGTH_SHORT).show(); it show my current state
                }
            });
            row.setTag(holder);
            holder.checkBox.setTag(position);
        }
        else
        {
            holder = (RowBeanHolder)row.getTag();
            ((RowBeanHolder) row.getTag()).checkBox.setTag(position);

        }

        if(longPressed){
            showCheckbox();
        }
        else{
            hideCheckbox();
            uncheck();
        }

        ProductList object = data.get(position);
        holder.txtTitle.setText(object.getName());
        holder.indicator.setText(object.getToBuy() + "/" + object.getBought());
        holder.checkBox.setChecked(data.get(position).isSelected());

        return row;
    }