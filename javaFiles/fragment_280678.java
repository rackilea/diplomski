@GetMapping("delete/{coupid}")
public String removeCoupon(@PathVariable int coupid) {

     couponService.deleteById(coupid);

     return "couponRemoved";
}