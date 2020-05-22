CREATE TABLE main_table (
    _ID INTEGER PRIMARY KEY AUTOINCREMENT, 
    account_id INTEGER NOT NULL, 
    employee_id INTEGER NOT NULL,
    rating REAL NOT NULL, 
    timestamp LONG NOT NULL, 
    FOREIGN KEY(account_id) REFERENCES ACCOUNTS(_ID) ON DELETE CASCADE,
    FOREIGN KEY(employee_id) REFERENCES EMPLOYEES(_ID) ON DELETE CASCADE,
    UNIQUE (account_id, employee_id, timestamp));