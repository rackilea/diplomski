private HashMap<String,String> downloadInLineImage(Item item, String dynamicOutputDirectory)
        throws Exception, ServiceLocalException {
    //create output directory if not present

        //bind the item to a new email message. if you do not bind, then the getHasAttachments() function will fail
    EmailMessage mostRecentMatch = (EmailMessage)item;
    String from = mostRecentMatch.getFrom().getAddress();
    String user =StringUtils.substringBefore(from, "@");
    AttachmentCollection collection=item.getAttachments();

    HashMap<String,String> inlineFiles=new HashMap<String,String>();

    if(collection.getCount()>0)
    {
        for (Attachment attachment : collection.getItems()) {

            if(attachment.getIsInline())
            {

                FileAttachment currentFile = (FileAttachment) attachment;
                String filePath=dynamicOutputDirectory+"/"+user+currentFile.getName();
                File file=new File(filePath);
                FileOutputStream fio=new FileOutputStream(file);
                currentFile.load(fio);
                inlineFiles.put(currentFile.getContentId(), filePath);
                fio.close();
            }
        }
    }