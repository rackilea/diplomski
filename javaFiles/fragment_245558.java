private Target getTargetForWrite()
{
    CommunityTarget target = new CommunityTarget();
    target.setCommunity(new OctetString("public"));\\<--- 
    target.setVersion(SnmpConstants.version2c);
    target.setAddress(GenericAddress.parse(address));
    target.setRetries(2);
    target.setTimeout(1500);

    return target;
}