@Override
    protected Map<String, MultipartRequest.DataPart> getByteData() {
        Map<String, MultipartRequest.DataPart> params = new HashMap<>();
        String imagename = imageUri.getLastPathSegment();
        params.put("uploadedfile", new MultipartRequest.DataPart(imagename,getFileDataFromDrawable(bitmap)));
        return params;
    }