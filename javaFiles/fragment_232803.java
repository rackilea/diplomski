TBitField = record
private
  FStorage: integer;
  function GetBit(Index: TBitRange): boolean;
  procedure SetBit(Index: TBitRange; const Value: boolean);
public
  property IsTrue[Index: TBitRange]: boolean read GetBit write SetBit;
end;