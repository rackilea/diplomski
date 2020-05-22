int result;
Set<String> keySet = node.keySet(); 
for (String key : keySet)
{
    switch (key)
    {
        case "ADD":
            result=evaluateAdd(node.getJsonArray("ADD"));
            break;
        case "MULT":
            result=evaluateMult(node.getJsonArray("ADD"));
            break;
        case "INT":
            result=node.getInt("INT");
            break;
         ...
    }
}