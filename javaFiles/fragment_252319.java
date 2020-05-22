unit MyJavaHelper;

interface

uses
  Androidapi.JNI.JavaTypes;

function JObjectToTObject(JavaObject: JObject): TObject;

implementation

function JObjectToTObject(JavaObject: JObject): TObject;
begin
  Result := JavaObject as TObject;
end;

end.