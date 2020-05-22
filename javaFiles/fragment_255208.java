public void next(View view) { 
    if (imVal == 1) { 
        imVal++; 
        iv1.setImageResource((R.drawable.n2)); 
    } else if (imVal == 2) { 
        imVal++; 
        iv1.setImageResource((R.drawable.n3)); 
    } else if (imVal == 3) { 
        imVal++; 
        iv1.setImageResource((R.drawable.n4)); 
    } else if (imVal == 4) { 
        imVal++; 
        iv1.setImageResource((R.drawable.n5)); 
    } else { 
        imVal = 1; 
        iv1.setImageResource((R.drawable.n1)); 
    } 
    String result = String.valueOf(imVal); 
    tv1.setText(result); 
} 

public void prev(View view) { 
    if (imVal == 5) { 
        imVal--; 
        iv1.setImageResource((R.drawable.n4)); 
    } else if (imVal == 4) { 
        imVal--; 
        iv1.setImageResource((R.drawable.n3)); 
    } else if (imVal == 3) { 
        imVal--; 
        iv1.setImageResource((R.drawable.n2)); 
    } else if (imVal == 2) { 
        imVal--; 
        iv1.setImageResource((R.drawable.n1)); 
    } else { 
        imVal = 5; 
        iv1.setImageResource((R.drawable.n5)); 
    } 
    String result = String.valueOf(imVal); 
    tv1.setText(result); 
}