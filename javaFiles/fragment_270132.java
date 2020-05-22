@Override
public View getView(int position, View convertView, ViewGroup parent) {


 final ViewHolder holder;
    if(convertView==null)
    {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(resource, parent, false);
        holder = new ViewHolder();
        convertView.setTag(holder);

    }
    else
    {
        holder = (ViewHolder) convertView.getTag();
    }
    holder.position = position;
    no=student.get(holder.position).get(TAG_StudentNo);
    name =student.get(holder.position).get(TAG_FullName);
    holder.StudentID= (TextView) convertView.findViewById(R.id.StudentID);
    holder.FullName= (TextView) convertView.findViewById(R.id.FullName);
    holder.FullName.setText();
    holder.StudentNo=(TextView) convertView.findViewById(R.id.StudentNo);
    holder.StudentNo.setText();
    holder.DeleteStudent = (ImageView) convertView.findViewById(R.id.DeleteStudent);
        holder.AlertIcon = (ImageView) convertView.findViewById(R.id.Alert);

     // add a listener for phone call
        holder.DeleteStudent.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

             id = student.get(holder.position).get(TAG_StudentID);
            Toast.makeText(getContext(),id,Toast.LENGTH_LONG).show();


            }

        });


        holder.AlertIcon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

             //   String email = MyCustomAdapter.listMap.get(holder.position).get("email");
              //  ActivityHelper.startActivity(ActivityManager.EMAIL, email);
            }

        });



    return convertView;