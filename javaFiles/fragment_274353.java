@Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        view = layoutInflater.inflate(R.layout.activity_demo6_1, null);

        ImageView img = (ImageView) view.findViewById(R.id.vImage);

        final TextView name = (TextView) view.findViewById(R.id.vName);
        final TextView write = (TextView) view.findViewById(R.id.vWrite);
        final TextView date = (TextView) view.findViewById(R.id.vDate);

        name.setText(articleName[i]);
        write.setText(articleAuthor[i]);
        date.setText(articleDate[i]);

        name.setOnClickListener(this);
        write.setOnClickListener(this);
        date.setOnClickListener(this);

        return view;
    }

@Override
  public final void onClick(final View v) {
    switch (v.getId()) {
      case R.id.vName:
        nameClick(); // Create corresponding methods for each click, if its the same functionality just use the same method on all switch cases
        break;
      case R.id.vWrite:
        writeClick();
        break;
      case R.id.vDate:
        dateClick();
        break;
      default:
        break;
    }
  }

private void nameClick(){
   Toast.makeText(context, name1.getText() + "\n" + write1.getText() + "\n" + date1.getText() + "" ,Toast.LENGTH_LONG).show();
}