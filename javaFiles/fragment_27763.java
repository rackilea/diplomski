static Map<Integer, String> valueMap = new HashMap<Integer, String>();
static {
    valueMap.put(1, "The value is 0");
    ...
    valueMap.put(100, "The value is 100");
}

public void myfunction(int i, bool condition)
{
    string str = "default";
    if(condition) {
        str = valueMap.get(i);  // Also do checks if the value is not found etc.
    }
}