[Code]

procedure CurStepChanged(CurStep: TSetupStep);
var
  AppPath, DependenciesLogPath: string;
  Dependencies: TArrayOfString;
  Count, I: Integer;
begin
  DependenciesLogPath := ExpandConstant('{#DependenciesLog}');

  if CurStep = ssInstall then
  begin
    { If dependencies log already exists, remove the previously installed dependencies }
    if LoadStringsFromFile(DependenciesLogPath, Dependencies) then
    begin
      Count := GetArrayLength(Dependencies);
      Log(Format('Loaded %d dependencies, deleting...', [Count]));
      for I := 0 to Count - 1 do
        DeleteFile(ExpandConstant('{app}\lib\' + Dependencies[I]));
    end;
  end
    else
  if CurStep = ssPostInstall then
  begin
    { Now that the app folder already exists, }
    { save dependencies log (to be processed by future upgrade) }
    if SaveStringToFile(DependenciesLogPath, {#DepedenciesToInstall}, False) then
    begin
      Log('Created dependencies log');
    end
      else
    begin
      Log('Failed to create dependencies log');
    end;
  end;
end;