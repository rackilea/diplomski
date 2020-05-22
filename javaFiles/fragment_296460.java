JPIPDatabinClass = class(TObject)
private
  ...
public
  constructor Create(AKakaduClassID: Integer; AStandardClassID: Integer; AJPIP: string);

  property KakaduClassID: Integer; read FKakaduClassID;
  property StandardClassID: Integer; read FStandardClassID;
  property JPIP: string; read FJPIP;
end;