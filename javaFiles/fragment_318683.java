SESSION1                      SESSION2
BEGIN TRANSACTION
ISOLATION LEVEL SERIALIZABLE;
                              BEGIN TRANSACTION 
                              ISOLATION LEVEL SERIALIZABLE;
SELECT counter FROM sdemo
WHERE id = 1;
-- result is '1'
                              SELECT counter FROM sdemo
                              WHERE id = 1;
                              -- result is '1'                        

UPDATE sdemo
SET counter = 2
WHERE id = 1;
-- Succeeds

                              UPDATE sdemo
                              SET counter = 2
                              WHERE id = 1;
                              -- hangs waiting on row lock
                              -- held by session 1


COMMIT;
-- Succeeds
                              -- UPDATE finishes (succeeds)

                              COMMIT;
                              -- Aborts with
                              ERROR: could not serialize access due 
                                     to concurrent update