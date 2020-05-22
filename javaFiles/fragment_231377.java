// replace T with type of 'conditionMap' object, it's not clear from your code
public static void getAndSendMessageItems(Function<T, List<NameMe>> serviceFunc,
        T conditionMap, Integer availdSendMsgCount, SendType sendType) { 
    List<NameMe> values = serviceFunc.apply(conditionMap);
    Integer sendPhoneCout = values.size(); 
    checkSendNumber(availdSendMsgCount, sendPhoneCout); 
    Log log = logMsgSend(content, sendPhoneCout, sendType); 
    for (NameMe i : values) {     
         i.sendMsgItem(content, log.getId());            
    }
}