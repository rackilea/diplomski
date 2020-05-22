catch (ConstraintViolationException conEx) {
            if (conEx.getConstraintName().contains("xyz_fK")) {
                //TODO Project Entity is violating it's constrain
            } 
            LOGGER.Info( "My log message", conEx.getConstraintName());
            LOGGER.ERROR( "My log message", conEx);