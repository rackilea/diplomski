HttpServletRequest request= engine.getHttpRequest();

@SuppressWarnings("unchecked")
Map<String,Object> params=request.getParameterMap();

for (Entry<String, Object> tmpEntry : params.entrySet()) {
    if (tmpEntry.getValue() instanceof UploadedFile) {
        UploadedFile myFile=(UploadedFile)tmpEntry.getValue();
        //Do something with the file
    }
}