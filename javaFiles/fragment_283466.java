procedure CurStepChanged(CurStep: TSetupStep);
begin
  if CurStep = ssInstall then
  begin
    DelTreeExceptSavesDir(WizardDirValue); 
  end;
end;