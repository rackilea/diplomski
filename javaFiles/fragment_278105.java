SELECT o
FROM orderitem oi
JOIN FETCH oi.book
JOIN FETCH oi.orders 
JOIN FETCH oi.user u 
WHERE u.id = 1;