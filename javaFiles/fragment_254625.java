function openTargetList(event) {

  O$.ajax.request(
    this, 
    event, {
      execute:  'form1:treeTable', 
      render:   'form1:treeTable', 
      listener: 'treeTableBean.openElement'
    }
  );

};