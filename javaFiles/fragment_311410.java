private boolean checkAuthorised(){
        PackageManager pm = getPackageManager();
        try {
            for (Signature sig :
                pm.getPackageInfo(pm.getNameForUid(getCallingUid()),
                        PackageManager.GET_SIGNATURES).signatures){
                LogUtils.logD("Signature: " + sig.toCharsString());
                if (Security.trustedSignatures.get(sig.toCharsString()) != null) {
                    return true;
                }
            }
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LogUtils.logD("Couldn't find signature in list of trusted keys! Possibilities:");
        for(String sigString : Security.trustedSignatures.keySet()){
            LogUtils.logD(sigString);
        }

        /* Crash the calling application if it doesn't catch */
        throw new SecurityException();

    }