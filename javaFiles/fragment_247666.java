there's actually a definitional reason for it.  Consider

        SELECT DISTINCT x FROM tab ORDER BY y;

For any particular x-value in the table there might be many different y
values.  Which one will you use to sort that x-value in the output?