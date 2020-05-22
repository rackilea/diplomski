@Override
    public boolean hasNext() {
      try {
        return !rs.isAfterLast();
      } catch (SQLException e) {
        throw new MyApplicationException("There was an error", e);
      }
    }