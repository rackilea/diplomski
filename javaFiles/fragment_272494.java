//pseudo-code
for I := 1 to 50000 do
begin
  if CanReallocInPlace(Str) then
    //Great when True; but this might not always be possible.
    ReallocMem(Str, Length(Str) + Length(Txt))
  else
  begin
    AllocMem(NewStr, Length(Str) + Length(Txt))
    Copy(Str, NewStr, Length(Str))
    FreeMem(Str)
  end;
  Copy(Txt, NewStr[Length(NewStr)-Length(Txt)], Length(Txt))
end;