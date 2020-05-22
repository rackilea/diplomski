SELECT v.PROC_INST_ID_
FROMACT_RU_VARIABLE v
WHERE (v.NAME_ = 'initiator' AND v.TEXT_ = 'user1') OR   
      (v.NAME_ = 'team' AND v.TEXT_ = 'team1')
GROUP BY v.PROC_INST_ID_
HAVING COUNT(*) = 2;   -- both attributes match