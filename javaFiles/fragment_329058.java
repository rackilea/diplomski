for(int i=0; i<n; i++) {
    final int j = i;
    btninput.get(i).setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            converswindow.get(j).append(Html.fromHtml("<b>Вы:</b> "+msginput.get(i).getText()+"<br />"));
            msginput.get(j).setText("");
        }
    });
}