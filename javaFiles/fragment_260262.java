var
  _string : WideString; // or UnicodeString

function teste3 : PWideChar; stdcall;
begin
  _string = 'teste'
  Result := PWideChar(_string);
end;