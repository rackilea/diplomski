type
  TBufferData = array[0..15] of Byte;
  TLongBytes = array[0..7] of Byte;

procedure putLong(var Buffer: TBufferData; L: Int64);
begin
  Buffer[0]:= TLongBytes(L)[7];
  Buffer[1]:= TLongBytes(L)[6];
  Buffer[2]:= TLongBytes(L)[5];
  Buffer[3]:= TLongBytes(L)[4];
  Buffer[4]:= TLongBytes(L)[3];
  Buffer[5]:= TLongBytes(L)[2];
  Buffer[6]:= TLongBytes(L)[1];
  Buffer[7]:= TLongBytes(L)[0];
end;