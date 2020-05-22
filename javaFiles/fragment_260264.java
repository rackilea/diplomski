function teste3(buffer: PByte; bufsize: Integer) : Integer; stdcall;
var
  _string : WideString; // or UnicodeString
  MaxChars: Integer;
begin
  _string := 'teste';
  MaxChars := (bufsize div sizeof(WideChar)) - 1;
  StrLCopy(PWideChar(buffer), PWideChar(_string), MaxChars);
  Result := Min(Length(_string), MaxChars);
end;