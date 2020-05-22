public static boolean isFirstRun() {
        RecordStore rs = null;
        try {
            rs = RecordStore.openRecordStore("myAwesomeRecordStore", false); //check
            return false; //record store exists, so it's not our first run
        } catch (Exception e) {
            //RecordStoreNotFoundException, but we need to catch others anway
            try {
                rs = RecordStore.openRecordStore("myAwesomeRecordStore", true); //create
            } catch (Exception e1) {}
        }
        finally {
            if (rs != null) try {rs.closeRecordStore();} catch (Exception e) {}
        }
        return true; //so, record store did not exist and it was created (if no error occured (there shouldn't be any errors anyway))
    }