@JsonIgnore
public int getOwnedSectionId(){
    if(this.ownednotes != null)
        return this.ownednotes.getMsectionid();
    return 1;
}