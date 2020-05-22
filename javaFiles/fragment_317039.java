this.setFilterChain(filterChain);
CaptureContent capContent = new CaptureResponse(response);
doFilter()
process();
response.setContentType("image/png");
response.getOutputStream().write(imagedata);