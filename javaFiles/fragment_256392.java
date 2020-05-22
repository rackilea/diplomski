String delimiter = this.separator;
    if (delimiter == null) {
        delimiter = DEFAULT_STATEMENT_SEPARATOR; // ";"
        if (!containsSqlScriptDelimiters(script, delimiter)) {
            delimiter = "\n";
        }
    }
    splitSqlScript(script, delimiter, statements);