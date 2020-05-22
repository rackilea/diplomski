Webb webb = Webb.create();
Response<String> response = webb
        .post("https://aptransport.in/CFSTONLINE/Reports/VehicleRegistrationSearch.aspx")
        .header("User-Agent",
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/34.0.1847.116 Chrome/34.0.1847.116 Safari/537.36")
        .header("Accept", "*/*")
        .header("Origin", "https://aptransport.in")
        .header("Referer",
                "https://aptransport.in/CFSTONLINE/Reports/VehicleRegistrationSearch.aspx")
        .header("X-MicrosoftAjax", "Delta=true")
        .param("ctl00$OnlineContent$ddlInput", "R")
        .param("ctl00$OnlineContent$txtInput", "AP31BF2942")
        .param("ctl00$OnlineContent$ScriptManager1",
                "ctl00$OnlineContent$Updatepanel1|ctl00$OnlineContent$btnGetData")
        .param("__EVENTTARGET", "")
        .param("__EVENTARGUMENT", "")
        .param("__VIEWSTATE",
                "/wEPDwUKMTE0MzI5ODM0MGRkdB0g7u2Z+Eg+a4Wr8QLkE1lzgSU=")
        .param("ctl00$OnlineContent$btnGetData", "Get Data")
        .connectTimeout(3000)
        .asString();

if (response.isSuccess()) {
    String result = response.getBody();
    System.out.println(result);
} else {
    System.out.println(response.getStatusCode());
    System.out.println(response.getResponseMessage());
    System.out.println(response.getErrorBody());
}