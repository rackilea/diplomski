} catch (Exception e) {
        logger.debug("Exception in shutdown:" + e.getMessage());
    }
}

public String getMessage() {
    BufferedReader reader = null;