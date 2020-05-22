function GetText(Text: PAnsiChar; Len: Integer): Integer; stdcall;
const
  S: AnsiString = 'Some text value';
begin
  Result := Length(S)+1;//include null-terminator
  if Len>0 then
    StrPLCopy(Text, S, Len-1);
end;