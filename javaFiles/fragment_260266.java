function Java_TDLL_test3(env: PJNIEnv; obj: JObject): JString; stdcall;
var
  _string : WideString; // or UnicodeString
begin
  _string := 'teste';
  Result := env^.NewString(env, PJChar(PWideChar(_string)), Length(_string));
end;