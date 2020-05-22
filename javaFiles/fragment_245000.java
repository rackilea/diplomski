int player = 1;
public void onClick(View view){ 
    if (b[x][y].isEnabled() { 
        b[x][y].setEnabled(false); 
        if (player == 1){ 
            b[x][y].setText("X"); 
            c[x][y] = 0; 
            player = 1; 
        } else {
            b[x][y].setText("O"); 
            c[x][y] = 1; 
            player = 2; 
        } 
    }
}