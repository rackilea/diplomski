public enum Level {     
        HIGH,     
        MEDIUM,     
        LOW 
    }

    def clazz = Class.forName("Level")
    println clazz.values()