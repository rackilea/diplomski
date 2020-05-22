else  if(disp == null && StringUtils.isNotBlank(contentType) && contentType.toLowerCase().substring(0, 7).equals("message")) {
    IMAPNestedMessage msg = (IMAPNestedMessage) p.getContent();
    Part p2 = (Part) msg;
    Multipart mp = (Multipart) p2.getContent();
    int count = mp.getCount();
    for (int i = 0; i < count; i++){
        addAttachment(mp.getBodyPart(i), fileNames, fileName);
    }
}