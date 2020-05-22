enum Test { 
    ...
    public static Test getByValue(String val) { 
        for (Test c : values()) {
            if (c.value.equals(val)) {
                return c;
            }
        }
    } 
} 

Test x = Test.getByValue("1A"); // x == Test.LETTER