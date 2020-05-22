type
  IStandardDataProvider<T> = interface(IInterface)
    ...
  end;

  IEventDataProvider = interface(IStandardDataProvider <TUpdateTest>)
    ...
  end;

type
  TLocalDataProviderFactory = class
  private
    DataProvider: TDictionary<string, IInterface>;
    DbConnectionManager : TDatabaseConnectionManager;
    DBConnection : TSQLConnection;
    Configuration : TConfigurationManager;

    procedure BuildDataProviderMap;

  public
    constructor Create;
    destructor Destroy; override;

    function GetDataProvider(DataProviderName: string): IInterface;
  end;

implementation

constructor TLocalDataProviderFactory.Create;
begin
  inherited Create;
  DbConnectionManager := TDatabaseConnectionManager.create;
end;

destructor TLocalDataProviderFactory.Destroy;
begin
  inherited;
  DbConnectionManager.Free;
  DataProvider.Free;
end;

function TLocalDataProviderFactory.GetDataProvider(DataProviderName: string): IInterface;
begin
  if not Assigned(DataProvider) then
    BuildDataProviderMap;

  if DataProvider.ContainsKey(DataProviderName) then
    Result := DataProvider.Items[DataProviderName]
  else
    Result := nil;
end;

procedure TLocalDataProviderFactory.BuildDataProviderMap;
begin
  DataProvider := TDictionary<string, IInterface>.Create;
  Configuration := TConfigurationManager.Create;
  DBConnection := DbConnectionManager.GetConnection(Configuration.GetConfiguration('sqlConnectionString'));
  DataProvider.Add('EventDataProvider', TLocalEventDataProviderImpl.Create(DBConnection) as IInterface);
  DataProvider.Add('TaskActivityDataProvider', TLocalTaskActivityDataProviderImpl.Create(DBConnection) as IInterface);
end;

end.