untypedResult = wt.queryPermissions();
resp.getWriter().println(" Response for QueryPermissions----");
if("No Error".equals(wt.errormsg)) {   
    Map<String, Map<String, Integer> hMap = 
        (Map<String, Map<String, Integer>) untypedResult;

    for (Map.Entry<String, Map<String, Integer>> me : hMap.entrySet()) {
        Map<String, Integer> value = me.getValue();
        WtQueryPerm perm = new WtQueryPerm(value.get("keyphrase_limit"),
                                           value.get("timeout_limit"),
                                           value.get("cost_per_call"),
                                           value.get("result_limit"));
        resp.getWriter().println(me.getKey() 
                                 + " :  Cost per call=" + perm.getCostPerCall() 
                                 + ", Keyphrase limit=" + perm.getKeyphraseLimit() 
                                 + ", Result limit=" + perm.getResultLimit() 
                                 + ", Timeout limit=" +  perm.getTimeoutLimit());

    }
}