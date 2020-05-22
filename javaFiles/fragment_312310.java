BFGlobalService betfair = new BFGlobalService_Service().getBFGlobalService();

APIRequestHeader header = new APIRequestHeader();
header.setClientStamp(0);
header.setSessionToken("someSessionToken");

GetEventTypesReq req = new GetEventTypesReq();
req.setHeader(header);
req.setLocale("");

GetEventTypesResp response = betfair.getAllEventTypes(req);