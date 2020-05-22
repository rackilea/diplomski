public void shiftCol (int offset)
{
    if(offset > 0){
       for(int j = _cols - 1; j >= 0; j--){
          for(int i = 0; i < _rows; i++){
              if (j - offset >= 0) 
                  _pixels[i][j] = _pixels[i][j-offset];
              else
                  _pixels[i][j] = new RGBColor();                    
          }    
       }
    } else {
       for(int j = 0; j <=_cols - 1; j++){
          for(int i = 0; i < _rows; i++){
              if (j - offset < _cols) 
                 _pixels[i][j] = _pixels[i][j-offset];
              else
                 _pixels[i][j] = new RGBColor();                   
          }    
       }         
    }
}