SELECT *
FROM `<project_name>.firebase_messaging.data`
WHERE
   _PARTITIONTIME = TIMESTAMP('<date as YYYY-MM-DD>')
   AND message_id = '<your message id>'
   AND instance_id = '<your instance id>'
ORDER BY event_timestamp;