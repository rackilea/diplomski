{$APPTYPE CONSOLE}

uses
  System.SysUtils, System.TypInfo;

type
  TMyEnum = (enumValue1, enumValue2);

  TMyEnumHelper = record helper for TMyEnum
  public
    function ToString: string;
  end;

function TMyEnumHelper.ToString: string;
begin
  Result := GetEnumName(TypeInfo(TMyEnum), ord(Self));
end;

begin
  Writeln(enumValue1.ToString);
  Writeln(enumValue2.ToString);
end.