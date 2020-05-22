List ls = //some data from you DAO
    if(ls.isEmpty()){
         model.addAttribute("response","NoData");
      }else{
         model.addAttribute("response",ls);
     }