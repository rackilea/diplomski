for(XSLFShape shape : mySlide){
    if (shape instanceof XSLFPictureShape){
        XSLFPictureShape pShape = (XSLFPictureShape)shape;
        XSLFPictureData pData = pShape.getPictureData();
        InputStream pIs = pData.getInputStream();
        // ...
    }
}