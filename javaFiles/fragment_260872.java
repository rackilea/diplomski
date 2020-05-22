functions:
  pricing:
    handler: pricing.ApiGatewayHandler
    events:
      - http:
          path: pricing/test
          method: get
          integration: lambda
          request:
            template:
              application/json: |
                #set($params = $input.params().querystring)
                {
                #foreach($paramName in $params.keySet())
                  "$paramName" : "$util.escapeJavaScript($params.get($paramName))"
                  #if($foreach.hasNext),#end
                #end
                }