function GetSignedBytes(Value: Int64): TArray<Shortint>;
var
  i: Integer;
begin
  SetLength(Result, 8);
  for i := 0 to 7 do 
    Result[7-i] := Shortint(Value shr (8*i));
end;