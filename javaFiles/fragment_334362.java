for (int i=0;i<drawables;i++){
        // 1,2
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // 
       final View rowView = inflater.inflate(R.layout.radiobutton, null);

        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount());
        rowView.setId(i);
        RadioButton rd = (RadioButton) rowView.findViewById(R.id.radiobtn);
        l1.addView(rd); // same view with same id R.id.radiobtn
        rd.setText(current.getAnswers().get(i).getAns());
    }