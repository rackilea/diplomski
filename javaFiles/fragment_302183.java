public@ResponseBody String edit_blocks(@ModelAttribute(value = "editblockbean") EditBlockBean editBlockBean, BindingResult result, ModelMap model) {    
    List <EditBlockBean> editBlockBeanList = branchservice.getBlocksForEdit(editBlockBean.getTitle());
    String jsonResult = "";
    try {
        if (editBlockBeanList != null && !editBlockBeanList.isEmpty()) {
            JSONArray jsonArray = new JSONArray();
            for (EditBlockBean ebb: editBlockBeanList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("blockNo", ebb.getBlockNo());
                jsonObject.put("lotNo", ebb.getLotNo());
                jsonObject.put("extent", ebb.getExtent());
                jsonObject.put("landValue", ebb.getLandValue());
                jsonObject.put("onBookingAmount", ebb.getOnBookingAmount());
                jsonArray.put(jsonObject);
            }
            jsonResult = jsonArray.toString();
        }
    } catch (Exception ex) {
        jsonResult = "";
        // append exception to log
    }
    return jsonResult;
}