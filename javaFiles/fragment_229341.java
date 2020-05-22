UPDATE BKPSERVER
set BKP_STATUS = 'S'
where rowid = (
    select rowid
    from BKPSERVER
    where CLIENT_IP = '192.168.0.16'
      AND BKP_STATUS='R'
    ORDER BY ROWID DESC
    LIMIT 1
);