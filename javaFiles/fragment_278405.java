DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
Date date =  df.parse(input);
SimpleDateFormat returnFormat 
    = new SimpleDateFormat("dd MMMMM yyyy", Locale.CHINA); 
// or Locale.CHINESE, Locale.PRC, all work on my machine
return returnFormat.format(date);