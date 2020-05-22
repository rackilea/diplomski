SELECT
    c.id,
    c.name,
    GROUP_CONCAT(p.number) AS numbers
FROM contact c
LEFT JOIN phoneNumber p
    ON c.id = p.contactId
GROUP BY
    c.id, c.name;