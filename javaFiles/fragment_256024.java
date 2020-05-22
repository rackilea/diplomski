String TEST = result;

ArrayList<String> Products = new ArrayList<>();
boolean flag = true;

while(flag == true){
  Products.add(TEST.substring(0,TEST.indexOf(' ')));
  TEST = TEST.substring(TEST.indexOf(' '));//cutting the last email added from the string
    if(TEST.equals(" ")){
       flag = false;
    }
    else{
       TEST = TEST.substring(1); //remove that space so that it doesn't get  
                                 //counted again in the next iteration
    }

}