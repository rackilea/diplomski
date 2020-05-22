private static Pattern operationPattern=Pattern.compile("^\\s*(OPERATION\\s*\\(\\s*)(.*)(\\);)",Pattern.CASE_INSENSITIVE);
    private static Pattern subOperationPattern=Pattern.compile("^(?:\\s*(OPERATION\\s*\\(\\s*))(.*)(?:\\)\\s*\\;\\s*)(?=\\,)|^(?:\\s*(OPERATION\\s*\\(\\s*))(.*)(?:\\)\\s*\\;\\s*)$",Pattern.CASE_INSENSITIVE);

    private void parseOperationText(String strText ){
        Matcher matcher=operationPattern.matcher(strText);
        if(matcher.find()) {
            //This is an OPERATION
            subOperations=new ArrayList<>();
            String strChain = matcher.group(2);
            int commaIdx = strChain.indexOf(",");
            if (commaIdx == -1) {
                //Operation without parameter
                operationType = strChain;
            } else {
                //Operation with parameters
                operationType = strChain.substring(0, commaIdx);
                strChain = strChain.substring(commaIdx + 1);
                while (strChain.length()>0) {
                    matcher = subOperationPattern.matcher(strChain);
                    if (matcher.find()) {
                        String subOpText=matcher.group(0);
                        strChain=StringUtils.stripStart(strChain.substring(matcher.end())," ");
                        if(strChain.startsWith(",")){
                            strChain=strChain.substring(1);
                        }
                        subOperations.add(new Operation(subOpText));
                    }
                    else{
                        commaIdx = strChain.indexOf(",");
                        if(commaIdx==-1)
                        {
                            subOperations.add(new Operation(strChain));
                            strChain="";
                        }
                        else{
                            subOperations.add(new Operation(strChain.substring(0,commaIdx)));
                            strChain=strChain.substring(commaIdx+1);
                        }
                    }
                }
            }
        }
        else {
            //Fixed value: we store the value as is
            fieldValue = strText;
            operationType = OperationType.NONE;
        }
    }

public Operation(String text){
        parseOperationText(text);
    }