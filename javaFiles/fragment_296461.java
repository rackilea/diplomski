function PRECINCT_DATABIN: JPIPDatabinClass;
function TILE_HEADER_DATABIN: JPIPDatabinClass;
...

implementation

var
  FPRECINCT_DATABIN: JPIPDatabinClass;
  FTILE_HEADER_DATABIN: JPIPDatabinClass;
...
  FPRECINCT_DATABIN := JPIPDatabinClass.Create( ... );
  FTILE_HEADER_DATABIN := JPIPDatabinClass.Create( ... );
...  

function PRECINCT_DATABIN: JPIPDatabinClass;
begin
  Result := FPRECINCT_DATABIN;
end;

function TILE_HEADER_DATABIN: JPIPDatabinClass;
begin
  Result := FTILE_HEADER_DATABIN;
end;
...