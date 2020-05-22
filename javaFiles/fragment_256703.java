public <T> ExportedData<T> getExportData(TypeToken<ExportedData<T>> tt, String exportUri) {
    Response response = _client.get(exportUri);
    // System.out.println(response.body.toString());
    ExportedData<T> exportedData = GsonSingleton.getGson().fromJson(response.body.toString(),
        tt.getType());
    return exportedData;
}