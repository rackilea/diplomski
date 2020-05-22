SELECT
  r.name as recipe_name,
  ri.measurement_amount as measurement_amount
FROM
  recipe r
  INNER JOIN recipe_ingredient ri on ri.recipe_id = r.id
WHERE
  r.id = #{id}