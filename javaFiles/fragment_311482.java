DELETE T_TRADE TT
 WHERE EXISTS (SELECT 1
                 FROM T_TRADE T
                 JOIN T_CASH_FLOW F
                   ON F.TRADE_ID = T.ID
                 JOIN APP_OWNER.T_UPSTREAM_SYSTEM S
                   ON S.ID = T.UP_SYS_ID
                WHERE trunc(T.RECORD_DATE) = trunc(?)
                  AND S.NAME = ?
                  AND T.ID = TT.ID );

DELETE T_CASH_FLOW FF
 WHERE EXISTS (SELECT 1
                 FROM T_TRADE T
                 JOIN T_CASH_FLOW F
                   ON F.TRADE_ID = T.ID
                 JOIN APP_OWNER.T_UPSTREAM_SYSTEM S
                   ON S.ID = T.UP_SYS_ID
                WHERE trunc(T.RECORD_DATE) = trunc(?)
                  AND S.NAME = ?
                  AND F.TRADE_ID = FF.TRADE_ID );