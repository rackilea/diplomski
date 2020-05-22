@RequestMapping(value = "/restaurant")
private  String restaurant(Map<String, Object> map,
@RequestParam(value = "id", required = false) Long id,HttpServletResponse response) {
    List<Restaurant> r=new ArrayList<Restaurant>();
    for(int i=0;i<5;i++)
    {
        Restaurant restaurant=new Restaurant();
        restaurant.setAbout("bla bla bla!"+i);
        restaurant.setName("REstaurant"+i);
        r.add(restaurant);
    }
    map.put("restaurants",r);
    return "myFragment";
}