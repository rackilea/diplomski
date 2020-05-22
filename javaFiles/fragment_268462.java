INSERT INTO my_stat(id, client_addr, pid, usename)
    SELECT
        nextval('mystat_sequence'), client_addr, pid, usename
    FROM (
        SELECT
           host(client_addr) as client_addr,
           pid ,
           usename
        FROM
           pg_stat_activity
        WHERE
           usename = current_user
    ) s
    WHERE
        NOT EXISTS (
           SELECT
              NULL
           FROM
              my_stat u
           WHERE
              current_date = u.creation
           AND
              s.pid = u.pid
           AND
              s.client_addr = u.client_addr
           AND
              s.usename = u.usename
        );