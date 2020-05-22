{$APPTYPE CONSOLE}

uses
  System.SysUtils, System.TypInfo;

type
  TMyEnum = (enumValue1, enumValue2);

  TMyEnumHelper = record helper for TMyEnum
  private
    const
      EnumNames: array [TMyEnum] of string = ('Friendly name 1', 'Friendly name 2');
  public
    function ToString: string;
  end;

function TMyEnumHelper.ToString: string;
begin
  Result := EnumNames[Self];
end;

begin
  Writeln(enumValue1.ToString);
  Writeln(enumValue2.ToString);
end.