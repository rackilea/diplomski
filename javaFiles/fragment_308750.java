private Integer temperature = null;

public void setTemperature(int t){
    if( temperature != null) {
        return;
    }

    if(t>= -15 && t<= 40){
      temperature = t;
    } else if(t< -15){
      temperature = -15;
    } else if(t> 40){
      temperature = 40;
    }
 }