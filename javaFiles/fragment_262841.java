for (int i=1;i<=2;i++){

     View view = LayoutInflater.from(getActivity()).inflate(R.layout.automationrow, container,false);
     TableRow newr = (TableRow) view.findViewById(R.id.R1);
     Tab.addView(newr);
     Log.d("check runs",String.valueOf(i)); //printed only once
     //Tab is the TableLayout
}