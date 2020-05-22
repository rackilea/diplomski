The GQL syntax can be summarized as follows:

SELECT [DISTINCT] [* | <property list> | __key__]
  [FROM <kind>]]
  [WHERE <condition> [AND <condition> ...]]
  [ORDER BY <property> [ASC | DESC] [, <property> [ASC | DESC] ...]]
  [LIMIT [<offset>,]<count>]
  [OFFSET <offset>]

  <property list> := <property> [, <property> ...]
  <condition> := <property> {< | <= | > | >= | = | != } <value>
  <condition> := <property> IN <list>
  <condition> := ANCESTOR IS <entity or key>
  <list> := (<value> [, <value> ...]])