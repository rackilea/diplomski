boolean shouldLog(HttpServletRequest request){
  String acceptHeader = request.getHeader("accept");
  if(acceptHeader != null){
     List<MediaType> mediaTypes = MediaType.parseMediaTypes(acceptHeader);
     for(MediaType mediaType : mediaTypes){
        if(mediaTypeSet.contains(mediaType)) return true;
     }
  }
  return false;
}