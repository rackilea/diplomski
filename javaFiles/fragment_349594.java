CREATE TABLE entry (
    _id INTEGER PRIMARY KEY,
    name TEXT,
    parent_id INTEGER DEFAULT 0,
    is_dir INTEGER DEFAULT 0,
    CONSTRAINT fk_parent FOREIGN KEY ( parent_id ) REFERENCES entry( _id )
);