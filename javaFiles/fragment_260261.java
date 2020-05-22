const
  _string : WideString = 'teste'; // or UnicodeString in D2009+

function teste3 : PWideChar; stdcall;
begin
  Result := PWideChar(_string);
end;