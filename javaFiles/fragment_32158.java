private List<NodeBean> buildNode(Integer parentId) {
      List<NodeBean> result = new ArrayList<>();
      List<NodeInfoBean> data = getData(parentId);
      for (NodeInfoBean nodeInfo : data){
           NodeBean node = NodeBean
                          .builder()
                          .id(nodeInfo.getId())
                          .text(nodeInfo.getText())
                          .children(buildNode(nodeInfo.getId()))
                          .build();
           result.add(node);
      }
     return result;
}