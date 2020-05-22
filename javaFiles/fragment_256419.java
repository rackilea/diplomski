while(true){
            c=dec.checkChar(dec.extractCode(t, d));
            if(c=='*'){
                 break;
              }
            d=d.shiftRight(7);
            decoded+=c;
            }