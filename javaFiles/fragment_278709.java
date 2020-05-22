public static function pad(str:String, minLength:uint, pad:String):String { 
    while (str.length < minLength) str = pad + str; 
    return str; 
} 

var color:Number=0x002233;
var hexColorStr:String = "#" + pad((0xFFFFFF-color).toString(16), 6, "0");