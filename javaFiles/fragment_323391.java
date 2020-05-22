@RequestMapping(value = "/kfc", method = RequestMethod.GET)
    public @ResponseBody Shop addCategory(HttpServletResponse response)
    {
        Shop shop = new Shop();
        shop.setName("Testing");
        shop.setStaffName(new String[]{"11", "22"});
        return shop;
    }