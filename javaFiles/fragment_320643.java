var
  Path: string;
  JavaPath: string;
  S: string;
  P: Integer;
begin
  Path := GetEnv('PATH');
  while (Path <> '') and (JavaPath = '') do
  begin
    P := Pos(';', Path);
    if P = 0 then
    begin
      S := Trim(Path);
      Path := '';
    end
      else
    begin
      S := Trim(Copy(Path, 1, P - 1));
      Path := Trim(Copy(Path, P + 1, Length(Path) - P)); 
    end;

    if Pos('JDK', Uppercase(S)) > 0 then
    begin
      JavaPath := S;
    end;
  end;

  if JavaPath = '' then
  begin
    Log('Java not found in PATH');
  end
    else
  begin
    Log(Format('Java is in "%s"', [JavaPath]));
  end;
end;