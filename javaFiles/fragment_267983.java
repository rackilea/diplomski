public class Result {
        String resultCode;
        List<DataObject> dataObjects;
        <GETTERS & SETTERS>
    }

    public class DataObject {
        String lastSyncDate;
        int count;
        String refType;
        List<Update> updates;
        List<Delete> deletes;
        <GETTERS & SETTERS>
    }

    public class Update {
        String artist;
        String albumTitle;
        String productTitle;
        String thumbnail;
        String lastSyncDate;
        String refId;
        <GETTERS & SETTERS>
    }

    public class Delete {
        String refId;
        <GETTERS & SETTERS>
    }