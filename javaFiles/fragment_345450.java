for (int i = 0; i < countInvitation; i++) {
   final TextView test1 = new TextView(this);
   final Button bAccept = new Button(this);
   bAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test1.setVisibility(View.GONE);
            }
   });
   final Button bReject = new Button(this);
}