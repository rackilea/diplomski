SELECT messages.message_id, messages.user_id, messages.created_at, 
COUNT(*) AS share_count 
FROM messages
INNER JOIN shares ON messages.message_id = shares.message_id
WHERE shares.created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR) 
GROUP BY shares.message_id
ORDER BY share_count DESC;