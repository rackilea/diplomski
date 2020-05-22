@GetMapping("/cars")
@ResponseBody
 public List<CarsDTO> getAllCarsByCat(@RequestParam(name="cat1", required=false) Integer cat1,
                                 @RequestParam(name="cat2", required=false) Integer cat2) {
     if (cat1!=null && cat2!=null)
         return carsService.getAllCarsByCat1AndCat2(cat1, cat2);
     else if (cat1!=null)
         return carsService.getAllCarsByCat1(cat1);
     else if (cat2!=null)
         return carsService.getAllCarsByCat2(cat2);
     else
         return carsService.getAllCars();

  }