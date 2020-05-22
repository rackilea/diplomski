select g.id as name 
FROM Gym  g 
LEFT JOIN g.listOfEquipment listOfEquipment
WHERE listOfEquipment.id in (:listOfEquipment)) 
GROUP BY g.id
HAVING count(g.id) = #{#listOfEquipment.size}