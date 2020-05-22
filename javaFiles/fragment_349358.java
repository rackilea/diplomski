Map<String, Object> params = new HashMap<>();                   
params.put("paramName1", "paramVal1")
params.put("paramName2", "paramVal2");

String script = "price  = doc['price'].value; margin = doc['margin'].value;
      if (price < threshold) { return price * margin / target };
      return price * (1 - discount) * margin / target;"
XContentBuilder builder = 
                    new ScriptScoreFunctionBuilder()
                    .script(script)
                    .lang("groovy")
                    .params(params)
                    .toXContent(XContentBuilder, params);