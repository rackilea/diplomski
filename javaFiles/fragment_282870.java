public class MyApiService {

JsonSlurper slurper = new JsonSlurper()

    public MyApiService() {

    }

    public JsonModel MyApiServiceCall(Integer someId) {
        String endpoint = "http://test-coregatewayapi.com/v1/" + someId
        RequestObject request  =  findTestObject('Object Repository/Deposits_Requests/GET/GET_De')
        request.setRestUrl(endpoint)
        ResponseObject resp = WS.sendRequestAndVerify(request)
        String getcontent = resp.getResponseBodyContent()
        def parsedJson = slurper.parseText(getcontent)
        def newModel = new JsonModel(parsedJson)
        return newModel
    }


}

@ToString
    class JsonModel {
        String typeId
        boolean isOk
        Float balance
    }