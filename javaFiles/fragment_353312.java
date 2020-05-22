public class Q8 {

boolean snowForecast() {
    boolean snow = false; 
    int temperature=-5;
    boolean rain=true;
    if(rain && temperature < 0) {
        return true;
    } else {
        return false;
    } 
}
}