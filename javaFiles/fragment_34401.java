try {
    int uuId = rpc.lUserIdByServerUserId(userId,newServerName);
    Log.w("uuId","uuId : "+uuId);
}
catch (NotFoundException nfe) {
    // do some calculations
}