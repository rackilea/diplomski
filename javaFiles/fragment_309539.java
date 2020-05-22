SELECT *
    FROM ( select  count(*),a, b, c,..., row_number() over (order by f, g) rn
            from t1, t2,...
            where some_conditions
    ) where rn between initial_row and final_row
    order by rn;