public void onClick(View event) { 
    if (event == btnBox1){ 
        counter++; 
        if (counter % 2 == 0){ 
            btnBox1.setText("X"); 
            btnBox1.setEnabled(false); 
        }
        if (counter % 2 == 1){
            btnBox1.setText("O");
            btnBox1.setEnabled(false);
        }
    }
}