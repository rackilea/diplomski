@Override
    public void onClick(View agr0) {
        String fetchedValues = ( inputValues.getText().toString());
        if(fetchedValues.length>0)
        {
          String []values = fetchedValues.split(",");
          txtTotalNum.setText(Integer.toString(values.length));//calculate the number of inputs
         double[] convertedValues = new double[values.length];

         double product1 =1.0;
         double product=1.0;

         for(int a = 0; a < convertedValues.length; a++){
            convertedValues[a] =Integer.parseInt(values[a]);
            //product *=convertedValues[a];
         }

         double geoMean = Math.pow(product, product1/convertedValues.length);
          GeoMean.setText(Double.toString(geoMean));
       }
       else
       {
          //alert the user that the field is empty
        }
    }