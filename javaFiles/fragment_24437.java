PROCEDURE update_curr_date(
  h_id    IN NUMBER,
  h_type   IN VARCHAR2,
  h_pnum IN VARCHAR2,
  h_curr_date    IN DATE,
  mode         IN VARCHAR2 DEFAULT 'INSERT');