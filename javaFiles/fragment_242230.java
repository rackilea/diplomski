public Item getItemWithParent(int parentID){
    Item result = null;
    if(this.categoryID == parentID){
        result = this;
    } else {
        for(Item nextChild : children){
            result = nextChild.getItemWithParent(parentID);
            if(result != null){
                break;
            }
        }
    }
    return result;
}