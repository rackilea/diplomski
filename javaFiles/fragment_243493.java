declare
   b1 boolean;
   b2 boolean;
   n1 number := 0;
   n2 number := 0; 
begin
   sp_xxxx_map( ?, ?, ?, b1, b2 );
   if (b1) then n1 := 1; end if;
   if (b2) then n2 := 1; end if;
   ? := n1;
   ? := n2;
end;