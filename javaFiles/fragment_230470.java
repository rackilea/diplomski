@Override
public void onCreate(SQLiteDatabase db) {
    String createEmpresasTable = "CREATE TABLE " + EMPRESAS_TABLE_NAME +
            "(id INTENGER PRIMARY KEY AUTOINCREMENT," +
            NOME_EMPRESA + " TEXT NOT NULL," +
            DESCRICAO_EMPRESA + " TEXT," +
            LOCALIDADE_EMPRESA + " TEXT NOT NULL," +
            AREA_EMPRESA + " TEXT NOT NULL," + ")";
db.execSQL(createEmpresasTable);// change here
}