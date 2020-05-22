{
  "formatVersion": 1,
  "database": {
    "version": 1,
    "identityHash": "53db508c5248423325bd5393a1c88c03",
    "entities": [
      {
        "tableName": "sms_table",
        "createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `message` TEXT, `date` INTEGER, `client_id` INTEGER)",
        "fields": [
          {
            "fieldPath": "id",
            "columnName": "id",
            "affinity": "INTEGER"
          },
          {
            "fieldPath": "message",
            "columnName": "message",
            "affinity": "TEXT"
          },
          {
            "fieldPath": "date",
            "columnName": "date",
            "affinity": "INTEGER"
          },
          {
            "fieldPath": "clientId",
            "columnName": "client_id",
            "affinity": "INTEGER"
          }
        ],
        "primaryKey": {
          "columnNames": [
            "id"
          ],
          "autoGenerate": true
        },
        "indices": [],
        "foreignKeys": []
      }
    ],
    "setupQueries": [
      "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)",
      "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"53db508c5248423325bd5393a1c88c03\")"
    ]
  }
}