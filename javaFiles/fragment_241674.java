String dataModel = ...;
// convert the string as a JSON object
engine.put("dataModel", dataModel);
JSObject obj = (JSObject)engine.eval("JSON.parse(dataModel)");
...
// dataModel is a script object - as it is a result of JSON.parse
// pass it as parameter for genData
inv.invokeFunction("genData", obj);