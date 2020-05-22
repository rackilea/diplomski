@PostMapping("{table}")
    public ResponseEntity createTable(@PathVariable("table") String tableName,
                                         @RequestBody File file) {
        validateAdding(tableName, tables, file);
        ...
}

validateAdding(String tableName, Map<String, Table> tables, File file){
    FilesValidator.validateAdding(tableName, tables, file);
}