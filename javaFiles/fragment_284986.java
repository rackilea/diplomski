@ResponseBody
    @RequestMapping(value="/checkIdDuplicate", method=RequestMethod.POST)
    public boolean checkIdDuplicate(@RequestParam String id) {

       return memberService.isExistByUserId(id);
    }