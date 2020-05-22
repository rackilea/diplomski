select g.name as name 
FROM Gym  g 
LEFT JOIN g.listOfEquipment listOfEquipment 
WHERE (((:listOfEquipment) is null) 
    OR g.id in (
    select g.id as name 
    FROM Gym  g 
    LEFT JOIN g.listOfEquipment listOfEquipment
    WHERE listOfEquipment.id in (:listOfEquipment)) 
    GROUP BY g.id
    HAVING count(g.id) = #{#listOfEquipment.size}   
)) 
AND (((:listOfAmenity) is null) 
    OR g.id in (
    select g.id as name 
    FROM Gym  g 
    LEFT JOIN g.listOfAmenity listOfAmenity
    WHERE listOfAmenity.id in (:listOfAmenity)) 
    GROUP BY g.id
    HAVING count(g.id) = #{#listOfAmenity.size}   
))