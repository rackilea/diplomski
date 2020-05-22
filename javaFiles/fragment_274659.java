INSERT INTO mytable
        (name, age)
    VALUES
        (
        #{name},
        #{age}
        )
    ON CONFLICT (name,age)
    DO NOTHING