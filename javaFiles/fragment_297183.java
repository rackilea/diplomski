<select id="selectCitiesByBoundaries" resultType="CityDTO">
  SELECT * FROM cities WHERE
  <foreach item="boundary" index="index" collection="#{boundaries}"
      open=" (" separator=") OR (" close=") ">
    lat > #{boundary.getLatMin()} AND
    lat < #{boundary.getLatMax()} AND
    lng > #{boundary.getLngMin()} AND
    lng < #{boundary.getLngMax()}
  </foreach>
</select>