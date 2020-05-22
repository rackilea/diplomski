int downloadStatus = ...;
DowloadStatus status = DowloadStatus.getStatusFromInt(downloadStatus);
switch (status) {
    case DowloadStatus.NOT_DOWNLOADED:
       //etc.
}