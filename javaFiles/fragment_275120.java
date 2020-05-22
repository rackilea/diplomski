DROP TABLE IF EXISTS tasks;
CREATE TABLE IF NOT EXISTS tasks (ID INTEGER PRIMARY KEY, name TEXT, user_reference INTEGER, priority DEFAULT 10);
DROP TRIGGER IF EXISTS set_task_priority;

-- Create the Trigger
CREATE TRIGGER IF NOT EXISTS set_task_priority 
    AFTER INSERT ON tasks
    WHEN ((SELECT count() FROM tasks WHERE user_reference = new.user_reference) > 3)
    BEGIN   
        UPDATE tasks SET priority = new.priority + (SELECT  count() FROM  tasks WHERE user_reference = new.user_reference)
        WHERE ID = new.ID
     ;
    END;

-- Add some data to test the trigger
INSERT INTO tasks (user_reference,name) VALUES 
    (1,'CLEAN'),(1,'TIDY'),(1,'VACUMN'),(1,'WASH'),(1,'THINK'),
    (2,'CLEAN'),(2,'TIDY'),(2,'VACUMN'),(2,'WASH'),
    (3,'CLEAN'),(3,'TIDY'),(3,'VACUMN'),(3,'WASH'),(3,'THINK'),(3,'STUDY'),
    (3,'CLEAN'),(3,'TIDY'),(3,'VACUMN'),(3,'WASH'),(3,'THINK'),(3,'STUDY'),
    (3,'CLEAN'),(3,'TIDY'),(3,'VACUMN'),(3,'WASH'),(3,'THINK'),(3,'STUDY'),
    (3,'CLEAN'),(3,'TIDY'),(3,'VACUMN'),(3,'WASH'),(3,'THINK'),(3,'STUDY')
;
INSERT INTO tasks (user_reference,name) VALUES (3,'SLEEP');
SELECT * FROM tasks;