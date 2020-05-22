(defn- parse-enum
  "Parses an enum string and returns it's components"
  [enum-str]
  ; "enum('temp','active','canceled','deleted')"
  (map (comp keyword #(.replace % "'" ""))
       (-> enum-str
           (.replaceFirst "^[^\\(]+\\(([^\\)]+)\\)$" "$1")
           (.split "'?,'?"))))

(defn get-enum-value 
  "Returns the values for an enum in a table.column"
  [table column]
  (jdbc/with-connection db
    (jdbc/with-query-results rs
      [(str "show columns from " table " where field = ?") column]
      ((comp set parse-enum :type first) rs))))