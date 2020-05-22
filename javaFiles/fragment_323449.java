compass.setOnClickListener(new View.OnClickListener() {   // i would like to use this button to switch from  normal map to rotate map
        public void onClick(View v) {

            if (isNormal)
                RotateMap();                     
            else 
                NormalMap();


            isNormal = !isNormal;

        }
    });