SELECT s.id
FROM shipment s
LEFT JOIN status_transition_message stm 
ON stm.initial_status = 1 AND stm.final_status = 3 AND stm.shipment_id = s.id
GROUP BY s.id
ORDER BY min(stm.date) DESC;