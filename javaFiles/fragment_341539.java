private void setChatRoomInvitationListener() {
    MultiUserChat.addInvitationListener(mXmppConnection,
            new InvitationListener() {

                @Override
                public void invitationReceived(Connection connection,
                        String room, String inviter, String reason,
                        String unKnown, Message message) {

                    //MultiUserChat.decline(mXmppConnection, room, inviter,
                        //  "Don't bother me right now");
                    // MultiUserChat.decline(mXmppConnection, room, inviter,
                    // "Don't bother me right now");
                    try {
                       muc.join("test-nick-name");
                       Log.e("abc","join room successfully");
                       muc.sendMessage("I joined this room!! Bravo!!");
                    } catch (XMPPException e) {
                       e.printStackTrace();
                       Log.e("abc","join room failed!");
                    }
                }
            });
}