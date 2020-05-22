// SAM bridge with lambda implementation
    window.addWindowListener(
        WindowBridge.windowOpened(
            b -> System.out.println("opening via lambda!")
        )
    );