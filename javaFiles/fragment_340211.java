CREATE TABLE user_accounts
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL CHECK(trim(name) > '')
) ;
ALTER SEQUENCE user_accounts_id_seq RESTART WITH 10001 ;