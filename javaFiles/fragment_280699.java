public String verificaCheckBox(){

Listcheck.clear();

if (cbPapel.isChecked())
    Listcheck.add(cbPapel.getText().toString());

if (cbPlastico.isChecked())
    Listcheck.add(cbPlastico.getText().toString());

if (cbMetal.isChecked())
    Listcheck.add(cbMetal.getText().toString());

if (cbVidro.isChecked())
    Listcheck.add(cbVidro.getText().toString());


    cbSelecionado = (Listcheck.toString());

return Listcheck.isEmpty() ? "Message goes here" : "";

}