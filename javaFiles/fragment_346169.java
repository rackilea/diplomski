public void downloadURL(String url) throws IOException {

    WebConversation wc = new WebConversation();
    WebResponse indexResp = wc.getResource(new GetMethodWebRequest(url));
    WebLink[] links = new WebLink[1];
    try {
        links = indexResp.getLinks();
    } catch (SAXException ex) {
        // Log
    }

    for (WebLink link : links) {
        try {
            link.click();
        } catch (SAXException ex) {
            // Log
        }
        WebResponse resp = wc.getCurrentPage();
        String fileName = resp.getURL().getFile();
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        System.out.println("filename:" + fileName);
        File file = new File(fileName);
        BufferedInputStream bis = new BufferedInputStream(
                resp.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(file.getName()));
        int i;
        while ((i = bis.read()) != -1) {
            bos.write(i);
        }
        bis.close();
        bos.close();
    }
    System.out.println("Done downloading.");
}