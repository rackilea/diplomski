List<String> bcm = plugin.message(); 

// You must check that your list isn't empty before doing your instructions
 if((bcm != null) && !bcm.isEmpty()){
    plugin.bc(bcm.get(bcnumber));


    if(bcnumber < bcm.size()-1){
        bcnumber++;
    }
    else{
        bcnumber = 0;
    }
 }


}