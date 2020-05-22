UPDATE BOOKS
SET
  ID = #{book.id}
  <if test="book.author != null">, AUTHOR=#{book.author}</if>
  <if test="book.name != null">, NAME=#{book.name}</if>
WHERE ID = #{book.id}