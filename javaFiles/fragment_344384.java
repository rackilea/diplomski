[Setup]
AppName=UninsPassword
AppVerName=UninsPassword
DisableProgramGroupPage=true
DisableStartupPrompt=true
DefaultDirName={pf}\UninsPassword

[Code]
function AskPassword(): Boolean;
var
  Form: TSetupForm;
  OKButton, CancelButton: TButton;
  PwdEdit: TPasswordEdit;
begin

  Result := false;
  Form := CreateCustomForm();
  try
    Form.ClientWidth := ScaleX(256);
    Form.ClientHeight := ScaleY(100);
    Form.Caption := 'Uninstall Password';
    Form.BorderIcons := [biSystemMenu];
    Form.BorderStyle := bsDialog;
    Form.Center;

    OKButton := TButton.Create(Form);
    OKButton.Parent := Form;
    OKButton.Width := ScaleX(75);
    OKButton.Height := ScaleY(23);
    OKButton.Left := Form.ClientWidth - ScaleX(75 + 6 + 75 + 50);
    OKButton.Top := Form.ClientHeight - ScaleY(23 + 10);
    OKButton.Caption := 'OK';
    OKButton.ModalResult := mrOk;
    OKButton.Default := true;

    CancelButton := TButton.Create(Form);
    CancelButton.Parent := Form;
    CancelButton.Width := ScaleX(75);
    CancelButton.Height := ScaleY(23);
    CancelButton.Left := Form.ClientWidth - ScaleX(75 + 50);
    CancelButton.Top := Form.ClientHeight - ScaleY(23 + 10);
    CancelButton.Caption := 'Cancel';
    CancelButton.ModalResult := mrCancel;
    CancelButton.Cancel := True;

    PwdEdit := TPasswordEdit.Create(Form);
    PwdEdit.Parent := Form;
    PwdEdit.Width := ScaleX(210);
    PwdEdit.Height := ScaleY(23);
    PwdEdit.Left := ScaleX(23);
    PwdEdit.Top := ScaleY(23);

    Form.ActiveControl := PwdEdit;

    if Form.ShowModal() = mrOk then
    begin
      Result := PwdEdit.Text = 'removeme';
      if not Result then
            MsgBox('Password incorrect: Uninstallation prohibited.', mbInformation, MB_OK);
    end;
  finally
    Form.Free();
  end;
end;


function InitializeUninstall(): Boolean;
begin
  Result := AskPassword();
end;