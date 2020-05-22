WHERE (...some condition ...) AND (.. some other condition ... )
    AND (
       (
         (SELECT md.[source] 
          FROM sports_service.meet.meet_detail md 
          WHERE md.meet_id = #{meetId}
         ) = 'MANUAL'
       )
      OR EXISTS (
        SELECT 1 
        FROM ...
      )
    )