@GetMapping(path="/orderItem/image/{itemId}")
@ResponseStatus(HttpStatus.OK)
public void getImageForOrderItem(@PathVariable("itemId") long itemId, HttpServletResponse response) { 
    byte[] buffer = orderServiceImpl.getImageForOrderItem(itemId);
    if (buffer != null) {
        response.setContentType("image/jpeg");
        try {
            response.getOutputStream().write(buffer);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}