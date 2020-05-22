public class YourClass{
    private boolean isBlankDataPresent(JSONObject inputObj, String[] keys) throws Exception {
        for (String key : keys) {
            String input = (String) inputObj.get(key);
            if( input == null || input.trim().isEmpty())
                throw new Exception(key +" is Empty");
        }
        return false;
    }

    public boolean validateData(JSONObject inputObj, String[] keys) throws Exception {
        boolean isBlankDataPresent= isBlankDataPresent(inputObj, keys);
        if (!isBlankDataPresent) {
            // do Your Stuff and return true
        } 
    }
}