try {

       // Blocks until a 'socket' is ready registered with selector is ready.
        selector.select();
        if(!selector.isOpen()) {
            break;//graceful exit since selector was not in use anyway
        }
        Set<SelectionKey> readyKeys = selector.selectedKeys();
        // ...        

     } catch (ClosedSelectorException ex) {

        // selector was closed while being used
        ex.printStackTrace();
     } catch (IOException ex) {

        // some other exception
        ex.printStackTrace();

    }