public static void doSFTP(Map<String, String> ftpParameters) {

        if (ftpParameters.get("ID_NAME").equals(
                NAPSCommonConstants.MFT_NAPSGPCS_INTF)) {
            // do sftp for NAPS GPCS Interface.
            uploadUsingSFTP(ftpParameters);
        }
    }