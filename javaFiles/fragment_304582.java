select  upper(convert('This is a têst','US7ASCII')),
        upper(convert('THIS is A test','US7ASCII'))
from dual;

select  1 from dual 
where upper(convert('This is a têst','US7ASCII')) =
             upper(convert('THIS is A test','US7ASCII'))