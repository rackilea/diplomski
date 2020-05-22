double num = 0.8979;        
for (Object object: assetClassCorrelationMatrix) {            
    List list = (List) object;                                    
    if(list.contains(num))
        System.out.println("The number " + num + " is found at index =  " + list.indexOf(num));
}