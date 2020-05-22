@PostAuthorize("hasPermission(returnObject, 'READ')")
public MyItem getMyItem(Long id) {
    return dao.getMyItem(id);
}

@PreAuthorize("hasPermission(#toDelete, 'DELETE')")
public void deleteMyItem(MyItem toDelete) {
    dao.delete(toDelete);
}