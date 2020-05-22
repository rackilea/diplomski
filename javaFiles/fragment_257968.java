public class SearchAction extends ActionSupport {

private String  urlRedirectAjax;

public String searchJSON(){

    StringBuilder urlResultat = new StringBuilder();
    JSONObject jObj = (JSONObject) new JSONTokener(jsonForm).nextValue();

    if(jObj == null)
        return ERROR;


    if(jObj.has("elementJSON")){
        JSONObject jsObjMot = (JSONObject) jObj.get("elementJSON");
        String separator = "";
        for(Object key : jsObjMot.keySet()){
            urlResultat.append(separator);
            separator = ";";
            urlResultat.append((String) key);
        }   
        urlResultat.append("&");
    }   

    .....

    urlRedirectAjax = urlResultat.toString();

    return SUCCESS;
}

public String getUrlRedirectAjax() {
    return urlRedirectAjax;
}

public void setUrlRedirectAjax(String urlRedirectAjax) {
    this.urlRedirectAjax = urlRedirectAjax;
 }
}