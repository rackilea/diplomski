@RequestMapping(value="/oldPath")
public ModelAndView doProductOld(
    @PathVariable(value = "oldProductId") Long oldProductId,
   Model model
) throws Exception {
    Product product = productDao.findByOldId(oldProductId);
    RedirectView red = new RedirectView(product.getUrlNewPath(),true);
    red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
    return new ModelAndView(red);
 }