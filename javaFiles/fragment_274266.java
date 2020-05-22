int BUY = 1;//Buy value
int SELL = 1;//Sell value
String block = "cobble";
String buyAndSell = BUY+":"+SELL; //throw it into a string

//inside the main class
this.getConfig().set("pathToValues."+block, buyAndSell);//put the values inside the config

//with an instance
pluginInstance.getConfig().set("pathToValues"+, buyAndSell);//put the values inside the config