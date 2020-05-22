if(convertView==null){

    //Inflate tabitem.xml file for each row
    vi = inflater.inflate(R.layout.tabitem, null);

    holder=new ViewHolder();
    holder.txt_Name = (TextView)vi.findViewById(R.id.txtmemberName);
    holder.txt_Status = (TextView)vi.findViewById(R.id.txtmemberStatus);
    holder.image = (ImageView)vi.findViewById(R.id.imgPlayer);
    holder.imgbtn_fuenka = (ImageButton) vi.findViewById(R.id.btnfusenka);
    holder.imgbtn_senka = (ImageButton) vi.findViewById(R.id.btnsenka);
    holder.tblrow_status = (TableRow)vi.findViewById(R.id.tblrowstatus);
    holder.layoutbtn = (RelativeLayout)vi.findViewById(R.id.layoutbutton);
    // add this line
    holder.imgbtn_fuenka.setOnClickListener(this);
    holder.imgbtn_senka.setOnClickListener(this);
    // do for how many object that you want


    vi.setTag(holder);
}