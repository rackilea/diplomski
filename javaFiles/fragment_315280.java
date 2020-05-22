try {
   ...
} catch (org.postgresql.util.PSQLException e) {
    System.out.println(e.getServerErrorMessage().getMessage());
} catch (Exception e) {
    System.out.println(e.getMessage());
}