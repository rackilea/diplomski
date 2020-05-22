INSERT OR IGNORE INTO predicates(predicate) VALUES (?);
INSERT OR IGNORE INTO objects(object) VALUES (?);
INSERT INTO statements(subject, predicate, object)
VALUES (?,
        (SELECT id FROM predicates WHERE predicate = ?),
        (SELECT id FROM objects WHERE object = ?)
       );