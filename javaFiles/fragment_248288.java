CREATE PROCEDURE p_results(
  @p_result_sets INT
)
AS
BEGIN
  IF @p_result_sets = 1 BEGIN
    SELECT 1 a;
  END
  ELSE IF @p_result_sets = 2 BEGIN
    SELECT 1 a;
    SELECT 1 b UNION SELECT 2 b;
  END
END;