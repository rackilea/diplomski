CREATE TABLE Bundles (
    bundle varchar,
    type varchar,
    ts timeuuid,
    version varchar,
    PRIMARY KEY (type, ts)
   );