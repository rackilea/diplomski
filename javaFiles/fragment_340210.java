CREATE TABLE user_accounts
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL CHECK(trim(name) > '')
) ;

-- The previous `CREATE` has actually worked as if it were defined like:
CREATE TABLE user_accounts
(
    -- Name of sequence = name of table || '_' || name of column || '_id'
    id INTEGER NOT NULL PRIMARY KEY DEFAULT nextval('user_accounts_id_seq'),
    name TEXT NOT NULL CHECK(trim(name) > '')
) ;