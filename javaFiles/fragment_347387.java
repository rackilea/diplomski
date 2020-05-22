{$APPTYPE CONSOLE}

uses
  SysUtils, Classes;

var
  i, j: Integer;

label
  outerloopend;

begin
  for i := 1 to 10 do
  begin
    for j := 1 to 10 do
    begin
      if i>5 then
        goto outerloopend;
      Write(Format('%d,%d ', [i, j]));
    end;
    Writeln;
  end;
outerloopend:
  Writeln('Edsger Dijkstra, sorry for using goto!');
  Readln;
end.