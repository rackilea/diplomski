textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             Intent intent = new Intent(SellActivity.this, OfferActivity.class);
             intent.putExtra("TextViewContent", textView.getText());
             startActivity(intent);
        }
});