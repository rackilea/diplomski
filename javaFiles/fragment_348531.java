WSCredential credential = (WSCredential) _sharedState.get(com.ibm.wsspi.security.
            auth.callback.Constants.WSCREDENTIAL_KEY);
UserRegistry registry = RegistryHelper.getUserRegistry(credential.getRealmName());
String[] grpList = ldapEntry.getAttribute("myEntGrps").getValues();
[..]
  credential.getGroupIds().add("group:"+credential.getRealmName()+"/"+registry.getGroupSecurityName(grpList[i]));