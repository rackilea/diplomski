@RequestMapping(value="/products/download", method=RequestMethod.GET)
@ResponseBody
public FileSystemResource downloadFile(@Param(value="id") Long id) {
    Product product = productRepo.findOne(id);
    return new FileSystemResource(new File(product.getFileUrl()));
}