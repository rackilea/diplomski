private void initElements(){

    ageValue[0] =(TextView)this.findViewById(R.id.age1Value);
    ageValue[1] =(TextView)this.findViewById(R.id.age2Value);
    ageValue[2] =(TextView)this.findViewById(R.id.age3Value);


   ageText[0] = (TextView)this.findViewById(R.id.age1Text);
   ageText[1] = (TextView)this.findViewById(R.id.age2Text);
   ageText[2] = (TextView)this.findViewById(R.id.age3Text);



        for(int i = 0; i<=2;i++){


    intValues[i] = a.getHours((i));
    stringValues[i] = String.valueOf(intValues[i]);
    ageValue[i].setText(stringValues[i]);

}