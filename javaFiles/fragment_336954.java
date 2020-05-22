finally {
        // It seems that the object supplied to the obj parameter is a
        // DirContext instance with reference to the same Ldap connection as
        // the original context. Since it is not the same instance (that's
        // the nameCtx parameter) this one really needs to be closed in
        // order to correctly clean up and return the connection to the pool
        // when we're finished with the surrounding operation.
        if (obj instanceof Context) {

            Context ctx = (Context) obj;
            try {
                ctx.close();
            }
            catch (Exception e) {
                // Never mind this
            }

        }
    }