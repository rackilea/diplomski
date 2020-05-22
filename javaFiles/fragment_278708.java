const
  names : array [0..4] of string  = ('ali','samad','kamel','djamel','mustapha');
var
 s : string;
begin
  try
    for s in names do
     Writeln(s);

  except
    on E: Exception do
      Writeln(E.ClassName, ': ', E.Message);
  end;
  readln;
end.