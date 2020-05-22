@RequestMapping(value="/enable", method=RequestMethod.GET)
    public String enableUser( @RequestParam("solicitudId") int solicitudId ,   
                              @RequestParam("detailId") int detailId, Model model){
        try{
            //do whatever you want with detailId and solicitudId
        }catch(Exception e){
            e.printStackTrace();
        }
        return  null;
}