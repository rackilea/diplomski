private String multipartMaxSize;

@Inject(StrutsConstants.STRUTS_MULTIPART_MAXSIZE)
public void setMultipartMaxSize(String multipartMaxSize) {
  this.multipartMaxSize = multipartMaxSize;
}