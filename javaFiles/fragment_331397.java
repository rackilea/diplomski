@RequestMapping(method = RequestMethod.POST, params = "delete")
public String deleteProduct(@RequestParam(value = "delete") int deleteProductId) {
   Product product = productService.findProduct(deleteProductId);
   productService.deleteProduct(product);
   ...
}