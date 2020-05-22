@RequestMapping(path="/owners/search")
     public String getAllOwner(Model model,@RequestParam("owner_name") String name,@RequestParam("shortCode") String code,

                            @RequestParam("phoneNumber") String phoneNumber,@RequestParam("countryName") Long countryId,
                            @RequestParam(value = "active", required = false) String active, @RequestParam("businessType") Long typeId
             ) {




        if(typeId==0)
            typeId=null;
        if(countryId==0)
            countryId=null;

         model.addAttribute("ownerList",ownerRepository.findOwnerDetails(typeId, countryId, name, code, status));

            return "data_list";
    }