HashMap<String,Object> plancodes = new HashMap<String,Object>();
while(rs.next()){
    for (String columname : key){                                           
        try{
            String colVal = rs.getString(columname);
            // logger.info("columname: "+columname+" colVal:"+colVal);
            plancodes.put(columname, colVal);
        }catch(Exception e){
            e.printStackTrace();
            logger.info(loggerLabel + "Error Exception: "+e);
        }
    }
    listobj.add(plancodes);
    // logger.info("plan code response..."); 
    // logger.info("brand: "+bean.getBrand()+ "\n product_type: "+ bean.getProductType() + "\n load_package: "+ bean.getLoadPackage() +"\n keyword: "+bean.getKeyword()+"\n denomination: "+bean.getDenomination()+"\n list_price: "+bean.getListPrice()+"\n retailer discount: "+bean.getRetailerDiscount()+"\n validity: "+bean.getValidity());        
}