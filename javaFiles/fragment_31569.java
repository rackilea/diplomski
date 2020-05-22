getSession()
            .createQuery(
                    "UPDATE Friend SET status = :status, actionUserId = :userId, lastModifyDate = :lastModifyDate 
              WHERE (userId = :userId AND friendId = :idUserFriend)
              ||    (userId = :idUserFriend AND friendId = :userId)  ")
            .setParameter("status", Integer.valueOf(InviteFriendState.CANCEL.getState()))
            .setParameter("userId", userId).setParameter("idUserFriend", idUserFriend)
            .setParameter("lastModifyDate", new Date()).executeUpdate();
}