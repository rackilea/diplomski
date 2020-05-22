function getMenuRequest(actionName,methodName){
    document.forms[0].action=actionName+".htm";
    document.forms[0].method.value=methodName;
    document.forms[0].target='workFrame';
    document.forms[0].submit();
}