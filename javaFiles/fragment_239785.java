//Pass our two LinkList to our new ErrorBean
List<ErrorBean> errorBeans = new ArrayList<ErrorBean>();
for (int i = 0; i < severity.size(); i++) {
    ErrorBean eb = new ErrorBean();
    eb.setSeverity(severity.get(i));
    if (messages.size()>i){
        eb.setMessages(messages.get(i));
    }
    errorBeans.add(eb);
}