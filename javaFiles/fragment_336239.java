table.setEnabled(false); 
Composite composite = table.getParent(); 
if ((null != composite) && (composite instanceof ScrolledComposite)) {
      ScrolledComposite scrolledComposite = (ScrolledComposite)composite;
      scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));  
}