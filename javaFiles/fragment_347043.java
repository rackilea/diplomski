RetryingTransactionHelper transactionHelper = transactionService.getRetryingTransactionHelper();
final String filename =  "TestSite" + System.currentTimeMillis();

NodeRef noderef = transactionHelper.doInTransaction(new RetryingTransactionCallback<NodeRef>() {
    public NodeRef execute() throws Throwable {
      final NodeRef parent = repositoryHelper.getCompanyHome();
      FileInfo fileInfo = fileFolderService.create(parent, filename, ContentModel.PROP_CONTENT);
      NodeRef node = fileInfo.getNodeRef();

      ContentWriter writer = contentService.getWriter(node, ContentModel.PROP_CONTENT, true);
      writer.setMimetype(MimetypeMap.MIMETYPE_TEXT_PLAIN);
      writer.setEncoding("UTF-8");
      writer.putContent(content);
      return node;
    }
});