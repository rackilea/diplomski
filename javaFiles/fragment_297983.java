<changeSet author="Joe Bloggs" id="42">
  <ext:loadData identityInsertEnabled="true" commentLineStartsWith="#"
            encoding="UTF-8"
            file="config/liquibase/changelog/data/foo.csv"
            quotchar="&#34;"
            separator=","
            tableName="FOO">
     <column name="bar" type="STRING"/>
     <column name="baz" type="STRING"/>
  </ext:loadData>
</changeSet>