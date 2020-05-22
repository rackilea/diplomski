@Override
public Representation handle() {
       ...
        } finally {
            if (Status.CLIENT_ERROR_METHOD_NOT_ALLOWED.equals(getStatus())) {
                updateAllowedMethods();
            } else if (Status.SUCCESS_OK.equals(getStatus())
                    && (getResponseEntity() == null || !getResponseEntity()
                            .isAvailable())) {
                getLogger()
                        .fine("A response with a 200 (Ok) status should have an entity. "
                                + "Changing the status to 204 (No content).");
                setStatus(Status.SUCCESS_NO_CONTENT);
            }
        }
    }
    return result;
}