// populate your map
HashMap<String, Object> data = new HashMap<String, Object>(); 
data.put("workstationUuid", "asdfj32l4kjlkaslkdjflkj34");
data.put("id", 123);
data.put("asdas", "Asdasd"); // this field does not appear in your class

Class<?> clazz = GetDashboard.class;
GetDashboard dashboard = new GetDashboard();
for (Entry<String, Object> entry : data.entrySet()) {
    try {
        Field field = clazz.getDeclaredField(entry.getKey()); //get the field by name
        if (field != null) {
            field.setAccessible(true); // for private fields
            field.set(dashboard, entry.getValue()); // set the field's value for your object
        }
    } catch (NoSuchFieldException | SecurityException e) {
        e.printStackTrace();
        // handle
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
        // handle
    } catch (IllegalAccessException e) {
        e.printStackTrace();
        // handle
    }
}