EgamePay.pay(thisActivity, payAlias, new EgamePayListener() {
    @Override
    public void paySuccess(String alias) {
        com.unity3d.player.UnityPlayer.UnitySendMessage("PayListener","paySuccess", alias);
    }

    @Override
    public void payFailed(String alias, int errorInt) {
        com.unity3d.player.UnityPlayer.UnitySendMessage("PayListener","payFailed", alias + "#" + errorInt);
    }

    @Override
    public void payCancel(String alias) {
        com.unity3d.player.UnityPlayer.UnitySendMessage("PayListener","payCancel", alias);
    }
});