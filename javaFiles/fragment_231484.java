package org.loggable;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static void main(String... args) throws IOException {
        SeContainer seContainer = SeContainerInitializer.newInstance()
                .initialize();

        Main main = seContainer.select(Main.class).get();
        main.loggableMethod();

        seContainer.close();
    }


    @Loggable
    public void loggableMethod() {
        Logger.getLogger(Main.class.getSimpleName()).info("Inside method.");
    }
}