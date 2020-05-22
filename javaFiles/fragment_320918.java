List<String> hobbies = Lists.newArrayList(cbBola, cbGame, cbMakan);
String result = Joiner.on(",").join(hobbies);

hasilInput.setMessage("Nama : " + txtNama.getText().toString() + "\n" +
                      "Kelas : " + txtKelas.getText().toString() + "\n" +
                      "Kamu Seorang " + radBut1.getText() + "\n" +
                      "Hobby : " + result  + "\n")
    .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
});