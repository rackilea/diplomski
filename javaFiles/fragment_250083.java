select max(timestamp), count(timestamp) as users, timestamp from bucketName where id like 'GameUser__%' AND 
skillSet.specialPower = 'Extreme Programmer' AND 
skillSet.kickPower = 1 AND 
skillSet.punchPower = 1 AND 
timestamp BETWEEN $sometimeIPassHere AND $sometimeIPassHere 
ORDER BY timestamp desc limit 1;