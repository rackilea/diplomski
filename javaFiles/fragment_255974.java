ExResult<Boolean> result = command.execute()
if (result.isSuccess()) {
    Boolean resultData = result.getData();
} else {
    //handle issue
    result.getReason();
}