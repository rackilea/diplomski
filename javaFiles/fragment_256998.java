private String interpretIMC(float imcValue) {           
    imagem = (ImageView)findViewById(R.id.imageBody);

    rgsexo = (RadioGroup)findViewById(R.id.rgSexo);
    int selectedId = rgsexo.getCheckedRadioButtonId();  // get the id
    View radioButton = radioButtonGroup.findViewById(radioButtonID);
    int idx = radioButtonGroup.indexOfChild(radioButton);

    switch (idx)   // switch on the button selected
    {
        case 0:
            if (imcValue < 20) {
                imagem.setImageResource(R.drawable.slim);
                return "Abaixo do Peso";
            } else if (imcValue < 24.9) {
                imagem.setImageResource(R.drawable.normal);
                return "Peso Normal";
            } else if (imcValue < 29.9) {
                imagem.setImageResource(R.drawable.fat);
                return "Acima do Peso";
            } else if (imcValue < 39.9) {
                imagem.setImageResource(R.drawable.fat);
                return "Obesidade Moderada";
            } else {
                imagem.setImageResource(R.drawable.fat);
                return "Obesidade Mórbida";
            }
            break;
        case 1:
            if (imcValue < 19) {
                return "Abaixo do Peso";
            } else if (imcValue < 23.9) {
                return "Peso Normal";
            } else if (imcValue < 28.9) {
                return "Acima do Peso";
            } else if (imcValue < 38.9) {
                return "Obesidade Moderada";
            } else {
                return "Obesidade Mórbida";
            }
         break;
   }
}