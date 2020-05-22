@Command
@NotifyChange({"allMediaData","allMedia"})
public void updateTable() {
    allMediaData.clear();
    allMediaData.addAll(db.getMedia(actualType.getLabel()));
    allMedia.AddAll(allMediaData);
}