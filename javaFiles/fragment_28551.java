String query = "CREATE TABLE IF NOT EXISTS `" + tableName + "` (" +
    "  `index` int(5) NOT NULL," +
    "  `station` int(5) NOT NULL," +
    "  PRIMARY KEY (`index`)," +
    "  UNIQUE KEY `station` (`station`)" +
    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";