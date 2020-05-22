// do some work
...

utx.commit(); } catch (RuntimeException e) {
if (utx != null) utx.rollback();
throw e; // or display error message 
} finally {
em.close();