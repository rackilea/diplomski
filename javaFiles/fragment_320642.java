var
  Path: string;
begin
  Path := FileSearch('java.exe', GetEnv('PATH'));
  if Path = '' then
  begin
    Log('Java not found in PATH');
  end
    else
  begin
    Path := ExtractFileDir(Path);
    Log(Format('Java is in "%s"', [Path]));
  end;
end;