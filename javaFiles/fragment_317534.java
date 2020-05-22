catch (Exception ex)
        {
            event.getMessage().setProperty("prevError",  ex.getMessage()  , PropertyScope.INVOCATION);
            event.getMessage().setProperty("prevErrorClass",  ex.getClass()  , PropertyScope.INVOCATION);
            failed = true;
        }