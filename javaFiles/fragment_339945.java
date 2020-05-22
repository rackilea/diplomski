if (k.equals(key)) {
                    cursor.close();
                    if (database.isOpen()) database.close();
                    ThemeDatabaseCache.lruCache.put(key, value);
                    return value;
                }