public static Algo14web al;   

 @RequestMapping(value = "/lab/getAlgo", method = RequestMethod.POST)
    public @ResponseBody Algo14web  getPicksByLeague()
    {
        if(this.al == null || time2update){
           Algo1DAO ad = new Algo1DAO();
           al = new Algo14web(ad.getAlgo(1)); // Long task
        }


        return al;   
    }