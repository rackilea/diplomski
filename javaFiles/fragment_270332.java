Double value = Double.parseDouble(value1);
String value1 = "0";
if(value != null){
    if(value == (double) Math.round(value)){
        if(value/1000000000 > 1.0){
            value1 = String.format("%.1f G", value/1000000000);
        }
        else if(value/1000000 > 1.0){
            value1 = String.format("%.1f M", value/1000000);
        }
        else if(value/1000 > 1.0){
            value1 = String.format("%.1f K", value/1000);
        }
        else{
            value1 = String.format("%.1f", value);
        }
    }
    else{
        value1 = String.format("%.2f", value);
    }
}