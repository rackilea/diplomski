public JSONObject toJSON(){
    JSONObject out = new JSONObject();
    out.put("rolename", rolename);
    out.put("expanded", expanded);
    out.put("folderID", folderId);

    JSONArray children = new JSONArray();
    for(int i = 0; i < this.children.length; i++){
        children.push(this.children[i].toJSON());
    }
    out.put("children", children);

    return out;
}