void setImage(String url) {
    final HTML imageHolder = new HTML();
    String imgTag = "<IMG src='"+url+"' />'";
    imageHolder.setHTML(imgTag);
    RootPanel.get("imageContainer").add(imageHolder); // imageContainer is a div
}