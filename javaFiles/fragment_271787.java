for (AbstractEntity affectedEntity : toDelete.getAffectedEntities()) {
    notifications.add(Notification.forUsersWithAccess(ActionType.UPDATE, affectedEntity));
    // Forcefully remove the associations from the affectedEntity to the Conflict, since we don't want to risk using CascadeType.DELETE
    affectedEntity.getConflicts().remove(toDelete);
}
ConflictDAO.getInstance().delete(toDelete);